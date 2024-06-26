package com.demo.reflection;

public class Start3 {
	
public static void main( String[] args ) throws Exception {
        
        // Récupération des méta-données à partir de la classe.
        Class<?> metadata = TestReflection.class;

        StringBuilder builder = new StringBuilder( metadata.getName() );
        while ( true ) {
            // On remonte sur le type parent, s'il y en a un.
            metadata = metadata.getSuperclass();
            if ( metadata == null ) break;
            
            // On insert en tête du StringBuilder le nouveau niveau d'héritage
            builder.insert( 0, metadata.getName() + " -> " );
        }
        
        // On affiche la hiérarchie d'héritage
        System.out.println( builder.toString() );
        
        System.out.println("\n*********************************************\n");
        
        // Récupération des méta-données à partir de la classe.
        metadata = TestReflection.class;
        
        // On retrouve toutes les interfaces directement implémentées par le type considéré.
        Class<?> [] implementedInterfaces = metadata.getInterfaces();
        
        // On affiche ces interfaces.
        for( Class<?> interfaceMetadata : implementedInterfaces ) {
            System.out.println( interfaceMetadata.getName() );
        }
    
    }

}
