package com.demo.reflection;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;



public class TestReflection extends Base implements Runnable, Serializable{

    private int aNumericValue;
    protected String aString;
    double aPrice;      // Visibilité "package" par défaut
    public Date aDate;
    
    public TestReflection() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    public TestReflection(int aNumericValue, String aString, double aPrice, Date aDate) {
		super();
		this.aNumericValue = aNumericValue;
		this.aString = aString;
		this.aPrice = aPrice;
		this.aDate = aDate;
	}




	public void publicMethod() {}
    private void privateMethod() {}
    
    public static void publicStaticMethod() {}
    private static void privateStaticMethod() {}




	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
    
    

    
}
