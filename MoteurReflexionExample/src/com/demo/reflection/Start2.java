package com.demo.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Start2 {

public static void main( String[] args ) throws Exception {
        
        // Récupération des méta-données à partir de la classe.
        Class<?> metadata = TestReflection.class;
        
        while ( true ) {
            // On affiche le type en cours d'analyse
            System.out.println( metadata.getName() );
            
            // On récupère les attributs déclarés dans le type courant.
            Field [] attributes = metadata.getDeclaredFields();
            
            // On affiche des informations sur les attributs du type.
            for( Field attribute : attributes ) {
                Class<?> attributeMetadata = attribute.getType(); 
            
                System.out.printf( 
                        "\t%-10s %s of type %s (isPrimitive: %b)\n",
                        Modifier.toString( attribute.getModifiers() ),
                        attribute.getName(), 
                        attributeMetadata.getName(),
                        attributeMetadata.isPrimitive()
                );
            }
            
            // On remonte sur le type parent, s'il y en a un.
            metadata = metadata.getSuperclass();
            if ( metadata == null ) break;
        }
    }

}
