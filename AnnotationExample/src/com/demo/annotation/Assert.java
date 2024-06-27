package com.demo.annotation;

public class Assert {

    /**
     * Test si les valeurs de deux paramètres sont identiques ou non.
     * @param expected La valeur attendue.
     * @param value La valeur constatée. */
    public static void assertEquals( int expected, int value ) {
        String message = String.format( "Expected value == %d, actual value == %d", expected, value );
        if ( expected != value ) throw new AssertException( message );
    }
    
    // Toutes autres méthodes de test nécessaires...
}
