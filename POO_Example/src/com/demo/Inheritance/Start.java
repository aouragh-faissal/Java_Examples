package com.demo.Inheritance;

import java.util.ArrayList;

public class Start {

	public static void main(String[] args) {


		 ArrayList<Person> persons = new ArrayList<>();
	        persons.add( new Person() );
	        persons.add( new Employee( 1, "Jason", "Bourne", "supremacy@cia.us", 10_000 ) );
	        persons.add( new Client( 7, "James", "Bond", "007@mi6.uk", "MI6" ) );
	        
	        for( Person person : persons ) {
	            System.out.println( person );
	        } 
	        
	        System.out.println( "-----------------------" );
	        
	        for( Person person : persons ) {
	            if ( person instanceof Employee ) continue;
	            System.out.println( person );
	        }
	}

}
