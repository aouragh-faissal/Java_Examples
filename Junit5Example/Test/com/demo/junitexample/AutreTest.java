/**
 * 
 */
package com.demo.junitexample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class AutreTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("set up before class");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("tear down after class");
	}

	@Test
	void testKo() {
		System.out.println("no ok");
		fail("Not yet implemented");
	}

	@Test
	void testOk() {
		System.out.println("ok");
	}

}
