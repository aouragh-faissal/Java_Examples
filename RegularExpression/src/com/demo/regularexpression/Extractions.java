package com.demo.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractions {

    public static void main(String[] args) {

        Pattern separatorRegExpr = Pattern.compile( "[/-]" );

        // --- Extract data with String.split ---
        String [] dates =  { "20-08-2010", "10/01/2017" };
        for (String date : dates) {
            // String [] dateParts = date.split( "[/-]" );      // Non optimisé
            String [] dateParts = separatorRegExpr.split( date );
            System.out.printf( "%s - %s - %s\n", dateParts[0], dateParts[1], dateParts[2] );
        }
        
        
        // --- Extract data with Matcher class - Caution: regular expressions are greedy ---
        Pattern htmlPattern = Pattern.compile( "<(.+?)>", Pattern.DOTALL );
        String htmlContent = "<html><head><title>Titre</title></head><body><h1>Titre visuel</h1></body></html>";
      
        Matcher htmlMatcher = htmlPattern.matcher( htmlContent );
        while ( htmlMatcher.find() ) {
            System.out.println( "Expression correspondante au motif: " + htmlMatcher.group( 0 ) );
            System.out.println( "Nom du tag: " + htmlMatcher.group( 1 ) );
        }

    }
    
}
