package com.demo.Inheritance;

public class Employee extends Person {

    private double salary;
    
    /* Empty constructor */
    public Employee() {
        super();
        this.setSalary( 0 );
    }
    
    /* Another constructor */
    public Employee( int identifier, String firstName, String lastName, String email, double salary ) {
        super( identifier, firstName, lastName, email );
        this.setSalary( salary );
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary( double salary ) {
        if ( salary < 0 ) {
            throw new RuntimeException( "A salary must be positive" );
        }
        this.salary = salary;
    }
    
    @Override 
    public String toString() {
        return super.toString() + " - win " + this.getSalary() + " euros";
    }
}
