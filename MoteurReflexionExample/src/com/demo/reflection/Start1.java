package com.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Start1 {
	
	public static void main( String[] args ) throws Exception {
	
	 // Récupération des méta-données à partir de la classe.
    Class<TestReflection> metadata = TestReflection.class;
    
    // On récupère les attributs publics disponibles à partir de la classe
    // (et y compris dans les classes parentes : Base et Object).
    Field[] attributes1 = metadata.getFields();
    
    // On affiche des informations sur ces attributs publics.
    for( Field attribute : attributes1 ) {
        System.out.printf( 
                "%s of type %s (isPrimitive: %b)\n",
                attribute.getName(), 
                attribute.getType().getName(),
                attribute.getType().isPrimitive()
        );
    }
    
    System.out.println("\n*********************************************\n");
    
 // On récupère tous les attributs déclarés dans la classe
    Field [] attributes2 = metadata.getDeclaredFields();
    
 // On affiche des informations sur les attributs.
    for( Field attribute : attributes2 ) {
        System.out.printf( 
                "%s of type %s (isPrimitive: %b)\n",
                attribute.getName(), 
                attribute.getType().getName(),
                attribute.getType().isPrimitive()
        );
    }
 
    System.out.println("\n*********************************************\n");
    
 // On récupère les méthodes déclarées dans le type courant
    Method [] methods1 = metadata.getDeclaredMethods();
    
    // On affiche des informations sur les méthodes de la classe
    for( Method method : methods1 ) {
        System.out.println( method.getName() );
    }
    
    System.out.println("\n*********************************************\n");
    
    // On récupère les méthodes publiques dans le type courant et les types parents
    Method [] methods2 = metadata.getMethods();
    
    for( Method method : methods2 ) {
        System.out.println( method.getName() );
    }
    
    System.out.println("\n*********************************************\n");
    
    // On récupère les constructeurs déclarés sur le type courant
    Constructor<?> [] constructors = metadata.getDeclaredConstructors();
    
    // On affiche des informations sur ces constructeurs
    for( Constructor<?> constructor : constructors ) {
        System.out.println( constructor.toString() );
    }
    
    
	}
}
