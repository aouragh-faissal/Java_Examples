package com.demo.regularexpression;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpExtraction {

	 public static void main(String[] args) {
	        
	        // --- IP address extraction ---
	        String result = execWithOutput( "ipconfig" );
	        
	        String interfaceName = "Adresse IPv4";
	        String regExp = interfaceName + "[\\.\\s]+: (\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})";
	        Pattern pattern = Pattern.compile( regExp, Pattern.DOTALL );

	        Matcher matcher = pattern.matcher( result );
	        if ( matcher.find() ) {
	            System.out.println( "Whole matched expression: " + matcher.group( 0 ) );
	            System.out.println( "IP address: " + matcher.group( 1 ) );
	        }
	        
	    }
	    
	    
	    public static String execWithOutput( String programName ) {
	        ProcessBuilder processBuilder = new ProcessBuilder( programName );
	        processBuilder.redirectErrorStream(true);

	        try {
	            Process process = processBuilder.start();  
	            try ( BufferedReader stream = new BufferedReader( new InputStreamReader( process.getInputStream() ) ) ) {
	                StringBuilder builder = new StringBuilder();
	                while ( true ) {
	                    String line = stream.readLine();
	                    if ( line == null ) break;
	                    builder.append( line ).append( "\n" );
	                }
	                process.waitFor();
	                return builder.toString();
	            }
	        } catch( Exception exception ) {
	            throw new RuntimeException( "Cannot launch process " + programName );
	        }
	    }
}
