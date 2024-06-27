package com.demo.annotation;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import com.demo.annotation.TestMethod.NoExceptionExpected;



public class TestRunner {
    
    private List<Class<?>> classesMetadata;
    
    /**
     * Constructeur de la classe TestRunner.
     * @param classesMetadata Les métadonnées de chaque classe de test.
     */
    public TestRunner( List<Class<?>> classesMetadata ) {
        this.classesMetadata = classesMetadata;
    }
    
    
    /**
     * Exécute chaque méthode de test de chaque classe de test. 
     */
    public void start() throws Exception {
        int testCount = 0;
        int goodCount = 0;
        
        for (Class<?> metadata : classesMetadata) {
            Object testInstance = metadata.getDeclaredConstructor().newInstance();

            Method [] methods = metadata.getDeclaredMethods();
            for( Method method : methods ) {
                TestMethod annotation = method.getAnnotation( TestMethod.class ); 
                if ( annotation == null ) continue;
                                
                testCount ++;
                System.out.printf( "%-50s -> ", metadata.getName() + "." + method.getName() );
                try {
                    method.invoke( testInstance );
                    if ( annotation.expected() != NoExceptionExpected.class ) {
                        // Si une exception était attendue => Ko
                        System.out.println( "KO - no exception detected!" );
                    } else {
                        goodCount ++;
                        System.out.println( "Ok" );
                    }
                } catch( Exception exception ) {
                    if ( annotation.expected() != NoExceptionExpected.class &&
                         // L'exception reçue est relative à la réflexion -> getCause()
                         annotation.expected().isInstance( exception.getCause() ) ) {
                        // Si l'exception était attendue => Ok
                        goodCount ++;
                        System.out.println( "Ok" );
                    } else {
                        // Exception non prévue ou de type AssertException => Ko
                        System.out.println( "KO !" );
                        exception.printStackTrace();
                    }
                }
                
            }
        }
        
        System.out.println( "--------------------------------------------------------" );
        System.out.printf( "%d test(s) - %d good test(s) - %d bad test(s)\n",
                            testCount, goodCount, testCount-goodCount );
    }

    /**
     * Cette méthode renvoi tous les types (classes, interfaces...) accessibles par le ClassLoader du projet.
     * @return Une liste contenant tous les noms de types accessibles.
     * @throws Exception Une exception peut être déclenchée si on ne peut 
     *                   lister les éléments accessibles par le ClassLoader
     */
    private static List<String> findAllClassesInProject() throws Exception {
        // On capture le ClassLoader du projet courant.
        ClassLoader classLoader = TestRunner.class.getClassLoader();
        Path path = Paths.get( classLoader.getResource( "." ).toURI() );
        int pathLength = path.toString().length() + 1;

        List<String> allClasses = new ArrayList<>();
        
        // On parcourt récursivement tous les fichiers présents dans le dossier.
        Files.walkFileTree( path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
                String relativePath = file.toString().substring( pathLength );
                // On vérifie qu'il s'agit bien du fichier de byte code Java.
                if ( relativePath.endsWith( ".class" ) ) {
                    String className = relativePath.replace( ".class", "" )
                                                   .replace( "/", "." )
                                                   .replace( "\\", "." );
                    allClasses.add( className );
                }
                // On poursuit au fichier suivant.
                return FileVisitResult.CONTINUE;
            }
        });

        return allClasses;
    }
    
    /**
     * Le point d'entrée de notre programme.
     * @param args Les arguments spécifiés sur la ligne de commande (actuellement non utilisés).
     */
    public static void main( String[] args ) {
        try {
            List<String> classesNames = findAllClassesInProject();
            List<Class<?>> testClasses = new ArrayList<>();
            for ( String className : classesNames ) {
                Class<?> metadata = Class.forName( className );
                if ( metadata.getAnnotation( TestClass.class) != null ) {
                    testClasses.add( metadata );
                }
            }
    
            TestRunner testRunner = new TestRunner( testClasses );
            testRunner.start();
            
        } catch( Exception exception ) {
            System.err.println( "Cannot scan project types" );
            exception.printStackTrace();
        }
    }
}