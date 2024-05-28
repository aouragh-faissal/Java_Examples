package com.demo.Inheritance;

public class Client extends Person {

    private String enterpriseName;
    
    /* Empty constructor */
    public Client() {
        super();
        this.setEnterpriseName( null );
    }
    
    /* Another constructor */
    public Client( int identifier, String firstName, String lastName, String email, String enterpriseName ) {
        super( identifier, firstName, lastName, email );
        this.setEnterpriseName( enterpriseName );
    }

    public String getEnterpriseName() {
        return this.enterpriseName;
    }
    
    public void setEnterpriseName( String enterpriseName ) {
        if ( enterpriseName != null ) {
            if ( enterpriseName.equals( "" ) ) {
                throw new RuntimeException( "enterpriseName cannot be empty" );
            } else {
                enterpriseName = enterpriseName.toUpperCase();
            }
        }
        this.enterpriseName = enterpriseName;
    }
    
    
    @Override 
    public String toString() {
        return super.toString() + " - work at " + this.getEnterpriseName();
    }
    
}
