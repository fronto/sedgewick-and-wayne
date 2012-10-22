package com.thomas.preparation.test;

import static org.junit.Assert.assertEquals;

public class TestUtils {

	public static void assertIntegersEqual(int actual, int expected) {
		assertEquals(Integer.valueOf(actual), Integer.valueOf(expected));
	}
	
	
}
