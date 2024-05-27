package com.demo.records;

public class Start {

	  public static void main( String[] args ) {
	        
	        // Test du constructeur sans paramètre.
	        Point p1 = new Point(10,10);
	        System.out.println( p1 );
	        
	        // Test du constructeur à deux paramètres.
	        Point p2 = new Point( 10, 10 );
	        System.out.println( p2 );
	        
	        System.out.println( "Egalité : " + ( p1.equals(p2) ) );
	        System.out.println( "Hash code : " + p2.hashCode() );
	        System.out.println( "Getters : " + p2.x() + " - " + p2.y() );
	        
	    }
    
}