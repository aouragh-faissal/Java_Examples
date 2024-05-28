package com.demo.junitexample;



import org.junit.Test;

public class TimeoutTest {

	  @Test( timeout = 10 /* 10 millisecondes */ )
	    public void test() throws InterruptedException {
	        Thread.sleep( 1000 /* 1 secondes */ );
	    }

}
