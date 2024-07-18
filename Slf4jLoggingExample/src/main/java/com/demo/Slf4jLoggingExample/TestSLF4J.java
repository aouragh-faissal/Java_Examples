package com.demo.Slf4jLoggingExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSLF4J {

    // Récupération de notre logger.
    private static final Logger LOGGER =  LoggerFactory.getLogger( TestSLF4J.class );

    // Le point d'entrée du programme.
    public static void main( String [] args ) {

        // On produit un log de niveau informatif.
        LOGGER.info( "Hello World with SLF4J / Log4J {}", 2 );

        try {
            int value = (int)( Math.random() * 2 );
            int result = 3 / value;
            LOGGER.info( "value == {} - result == {}", value, result );
        } catch( Exception exception ) {
            LOGGER.error( "Houston, we have a problem.", exception ); 
        }
        
    }
    
}