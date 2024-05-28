package com.demo.referenceMethode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
    public static void main( String [] args ) {
        
        List<String> collection = new ArrayList<>();
        collection.add( "Java" );
        collection.add( "c" );
        collection.add( "Python" );
        collection.add( "C++" );
        collection.add( "ada" );
        collection.add( "lisp" );
 
        /*
Collections.sort(collection, new Comparator<String>() {

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	
});
*/
        collection.sort( (l1, l2) -> l1.compareToIgnoreCase( l2 ) );
        
		/*
		 * for ( String language : collection ) { System.out.println( language ); }
		 */
        
        collection.forEach(System.out :: println);
        
        Predicate<String> pred = (s) -> s.length() <= 4 ;
        collection.stream().filter(pred).forEach(System.out :: println);
        
    }
}