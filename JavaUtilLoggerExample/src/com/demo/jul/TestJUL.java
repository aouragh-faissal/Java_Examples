package com.demo.jul;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestJUL {

    // Récupérarion d'un notre gestionnaire de logs.
    private static final LogManager logManager = LogManager.getLogManager();

    // Récupération de notre logger.
    private static final Logger LOGGER = Logger.getLogger( TestJUL.class.getPackage().getName() );

    // Le bloc statique pour configurer le gestionnaire de logs
    static{
        try {
            logManager.readConfiguration( new FileInputStream("jul.properties") );
        } catch ( IOException exception ) {
            LOGGER.log( Level.SEVERE, "Cannot read configuration file", exception );
        }
    }

    // Le point d'entrée du programme.
    public static void main( String [] args ) {

        LOGGER.info( "Hello World with java.util.logging" );
        
        try {
            int value = (int)( Math.random() * 2 );
            int result = 3 / value;
            Object [] data = { value, result };
            LOGGER.log( Level.INFO, "value == {0} - result == {1}", data );
        } catch( Exception exception ) {
            LOGGER.severe( "Mon message d'erreur : " + exception );
        }
        
    }
}