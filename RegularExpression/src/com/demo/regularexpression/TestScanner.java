package com.demo.regularexpression;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) throws IOException {

		/*
		 * try ( Scanner scanner = new Scanner( System.in ) ) {
		 * 
		 * System.out.print( "Veuillez saisir un premier entier : " ); int a =
		 * scanner.nextInt();
		 * 
		 * System.out.print( "Veuillez saisir un second entier : " ); int b =
		 * scanner.nextInt();
		 * 
		 * int result = a + b; System.out.printf( "La somme de %d et de %d vaut %d\n",
		 * a, b, result );
		 * 
		 * }
		 */
		
		/*
		 * String[] command = {"netstat", "-ano"}; ProcessBuilder processBuilder = new
		 * ProcessBuilder( command ); processBuilder.redirectErrorStream( true ); try
		 * (Scanner scanner = new Scanner( processBuilder.start().getInputStream() )) {
		 * while ( scanner.hasNext() ) { String line = scanner.nextLine(); if (
		 * line.length() > 0 ) { System.out.println( line ); } } System.out.println(
		 * "-------------------------------------\nBye bye" ); }
		 */
		
		
		try ( Scanner scanner = new Scanner( System.in ) ) {
            // La valeur double devra utiliser le . comme séparateur de partie décimale
            scanner.useLocale( Locale.ENGLISH );
            scanner.useDelimiter( " +; +" );
            
            System.out.print( "Enter an IP address, a double value and an email: " );
            
            String ip = scanner.next( "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}" );
            System.out.println( "IP address == " + ip );
            
            double value = scanner.nextDouble();
            System.out.println( "double == " + value );

            String email = scanner.next( "[\\w.-]+@[\\w.-]+\\.[a-z]{2,}" );
            System.out.println( "email == " + email );
        }
        
    }
}
