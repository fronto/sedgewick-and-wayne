package com.thomas.preparation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestUtils {

	public static void assertIntegersEqual(int actual, int expected) {
		assertEquals(Integer.valueOf(actual), Integer.valueOf(expected));
	}

	public static <E extends Exception> void expectException(
			Class<E> exception, ThrowsException throwing) {
		try {

			throwing.throwExcpetion();
			fail("expected exception not thrown");

		} catch (Exception e) {
			assertTrue(exception.isAssignableFrom(e.getClass()));
		}

	}

	public static interface ThrowsException {

		void throwExcpetion();
	}

}
