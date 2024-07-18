package com.demo.Log4j2LoggingExample;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4J {

    // Récupération de notre logger.
    private static final Logger LOGGER =  LogManager.getLogger(TestLog4J.class );

    // Le point d'entrée du programme.
    public static void main( String [] args ) {
        
        // On produit un log de niveau informatif.
        LOGGER.log( Level.INFO, "Hello World with Log4J {}", 2 );

        try {
            int value = (int)( Math.random() * 2 );
            int result = 3 / value;
            LOGGER.info( "value == {} - result == {}", value, result );
        } catch( Exception exception ) {
            LOGGER.error( "Houston, we have a problem.", exception ); 
        }
        
    }

}
