package com.demo.regularexpression;

public class RegExpMatching {
    
    public static boolean isValidEmail( String email ) {
        //String regExp = "^.+@.+\\..+$";
        //String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z][a-z]+$";
        String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        return email.matches( regExp );
    }
    
    
    public static void main(String[] args) {
        
      // --- Good Emails ---
      System.out.println( isValidEmail( "dominique.liard@infini-software.com" ) );
      System.out.println( isValidEmail( "martin@societe.com" ) );
      System.out.println( isValidEmail( "martin@societe.fr" ) );
      
      System.out.println( "-----------------------------" );
      
      // --- Bad Emails ---
      System.out.println( isValidEmail( "martin.societe.com" ) );   // No @ character
      System.out.println( isValidEmail( "martin@societe" ) );       // No . character
      System.out.println( isValidEmail( "@@@.@" ) );
      System.out.println( isValidEmail( "martin@societe.f" ) );
       
    }
    
}
