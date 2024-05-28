/**
 * 
 */
package com.demo.junitexample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class BidonTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("set up");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tear down");
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
