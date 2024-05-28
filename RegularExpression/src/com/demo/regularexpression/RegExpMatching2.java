package com.demo.regularexpression;

public class RegExpMatching2 {
	
	public static boolean isValidDate( String date ) {              // jj/mm/aaaa    jj/mm/aa
        String regExp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)?[0-9]{2}$";
        return date.matches( regExp );
    }
    
    
    public static void main(String[] args) {
        
        // --- Good Dates ---
        System.out.println( isValidDate( "30/05/2017" ) );
        System.out.println( isValidDate( "30/05/17" ) );
        
        System.out.println( "-----------------------------" );
        
        // --- Bad Dates ---
        System.out.println( isValidDate( "00/10/1999" ) );
        System.out.println( isValidDate( "36/10/1999" ) );
        System.out.println( isValidDate( "26/00/1999" ) );
        System.out.println( isValidDate( "26/13/1999" ) );
        System.out.println( isValidDate( "30/05/017" ) );
        System.out.println( isValidDate( "30/5/17" ) );
        System.out.println( isValidDate( "3/05/17" ) );
        System.out.println( isValidDate( "martin@societe.com" ) );
        System.out.println( isValidDate( "jj/mm/aaaa" ) );
        
    }

}
