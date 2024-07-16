package com.demo.jul;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestLogGuard {

    // Un compteur pour démultiplier la problématique 
    private static final int LOOP_COUNT = 10_000_000;

    // Récupération d'un notre gestionnaire de logs.
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

    // Deux attributs utiles pour notre simulation de toString.
    private String aName = "AName";
    private double aValue = Math.random() * 100;
    
    // On simule un traitement itératif qui produit régulièrement des logs.
    public void doSomething() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            aValue += 0.01;
            if ( LOGGER.isLoggable( Level.INFO ) )
                LOGGER.info( i + ": A message " + this );
        }
    }
    
//    public void doSomething() {
//        for (int i = 0; i < LOOP_COUNT; i++) {
//            aValue += 0.01;
//            LOGGER.log( Level.INFO, "{0}: A message {1}", new Object[] { i, this } );
//        }
//    }

    /*
     * Une méthode pour transformer une instance en chaîne de caractères.
     * L'idée est de simuler l'affichage d'objets complexes dans les logs,
     * ce qui est très utile quand on trace l'activité d'un programme.
     */
    @Override
    public String toString() {
        return "TestLogGuard[aName=" + aName + ", aValue=" + aValue + "]";
    }
    

    // Le lancement de la démonstration.
    public static void main(String[] args) {
        TestLogGuard test = new TestLogGuard();
        
        // On prend des mesures de temps pour chronométrer le temps pris par doSomething.
        long begin = System.currentTimeMillis();
        test.doSomething();
        long end = System.currentTimeMillis();
        
        System.out.println( "Duration : " + (end - begin)  + "ms" );
    }

}