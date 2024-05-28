package com.demo.poo;

public class Start {

	 public static void main( String [] args ) {
	        
	        Rational r1 = new Rational( 1, 0 );
	        Rational r2 = new Rational( 2, 1 );
	        Rational result = r1.add( r2 );
	        System.out.println( result );
	        
	        if ( ! result.eq( new Rational( 7, 3 ) ) ) {
	            throw new RuntimeException( 
	                    "Certainnement un pb d'addition ou de comparaison" );
	        }
	    
	        Rational r3 = new Rational( 3.5 );
	        System.out.println( r3 );
	        if ( ! r3.eq( new Rational( 7, 2 ) ) ) {
	            throw new RuntimeException( 
	                    "Certainnement un pb de simplification" );
	        }
	     
	        System.out.println( "Tout semble OK :-)" );
	    }

}
