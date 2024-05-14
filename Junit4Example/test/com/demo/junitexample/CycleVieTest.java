package com.demo.junitexample;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CycleVieTest {

	@BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println( "@BeforeClass" );
    }
    
    @Before
    public void setUp() {
        System.out.println( "@Before" );
    }

    @Test
    public void test1() {
        System.out.println( "test1" );
    }

    @Test
    public void test2() {
        System.out.println( "test2" );
    }

    @Test
    public void test3() {
        System.out.println( "test3" );
    }

    @After
    public void tearDown() {
        System.out.println( "@After" );
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println( "@AfterClass" );
    }

}
