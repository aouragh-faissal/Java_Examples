package com.demo.test;



public class JavaTest {

	 public static void main( String [] args ) {
	        
	        int accumulator = 0;
	        
	        for( String param : args ) {
	            accumulator += Integer.parseInt( param );
	        }
	        
	        System.out.println( accumulator );
	        
	    }

}
