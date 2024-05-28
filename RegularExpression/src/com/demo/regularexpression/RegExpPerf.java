package com.demo.regularexpression;

import java.util.regex.Pattern;

public class RegExpPerf {

	 private static final String OCTET = "[0-9]|[0-9]{2}|[0-1][0-9]{2}|2[0-4][0-9]|25[0-5]";
	    private static final String REG_EXP = "^((" + OCTET + ")\\.){3}(" + OCTET + ")$";
	    
	    private static final Pattern IP_CHECKER_STATE_MACHINE = Pattern.compile( REG_EXP ); 
	    
	    
	    public static boolean isValidAddress( String address ) {              // jj/mm/aaaa    jj/mm/aa
	        return IP_CHECKER_STATE_MACHINE.matcher( address ).matches();
	    }

	    public static boolean isValidAddressOld( String address ) {           // jj/mm/aaaa    jj/mm/aa
	        return address.matches( REG_EXP );
	    }

	    
	    public static void main(String[] args) {

	        long begin = System.currentTimeMillis();
	        
	        for( int i=0; i<1_000_000; i++ ) {
	            isValidAddressOld( "192.168.1.100" );
	        }
	        
	        long end = System.currentTimeMillis();
	        System.out.println( "Duration Before Optims: " + (end-begin) + "ms" );

	        
	        
	        begin = System.currentTimeMillis();
	        
	        for( int i=0; i<1_000_000; i++ ) {
	            isValidAddress( "192.168.1.100" );
	        }
	        
	        end = System.currentTimeMillis();
	        System.out.println( "Duration After Optims: " + (end-begin) + "ms" );
	        
	    }
	    
}
