package com.demo.Slf4jLoggingExample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogGuard {

    // Un compteur pour démultiplier la problématique 
    private static final int LOOP_COUNT = 10_000_000;

    // Récupération de notre logger.
    private static final Logger LOGGER =  LoggerFactory.getLogger( TestSLF4J.class );

    // Deux attributs utiles pour notre simulation de toString.
    private String aName = "AName";
    private double aValue = Math.random() * 100;
    
    // On simule un traitement itératif qui produit régulièrement des logs.
    public void doSomething() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            aValue += 0.01;
            LOGGER.info( i + ": A message " + this );
        }
    }
    
    //with log guard
    public void doSomething2() {
        for (int i = 0; i < LOOP_COUNT; i++) {
            aValue += 0.01;
            if ( LOGGER.isInfoEnabled() )
                LOGGER.info( i + ": A message " + this );
        }
    }
    
    //without concatenation
    public void doSomething3() {
    	  for (int i = 0; i < LOOP_COUNT; i++) {
    	        aValue += 0.01;
    	        LOGGER.info( "{}: A message {}", i, this );
    	    }
    	}

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
        test.doSomething3();
        long end = System.currentTimeMillis();
        
        System.out.println( "Duration : " + (end - begin)  + "ms" );
    }

}