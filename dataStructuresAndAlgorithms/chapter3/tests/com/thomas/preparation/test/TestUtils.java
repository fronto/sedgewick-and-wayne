package com.thomas.preparation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class TestUtils {

	public static void assertIntegersEqual(int actual, int expected) {
		assertEquals(Integer.valueOf(actual), Integer.valueOf(expected));
	}

	public static <E extends Exception> void expectException(final
			Class<E> exception, ThrowsException throwing) {
		try {

			throwing.throwExcpetion();
			fail("expected exception not thrown");

		} catch (final Exception e) {
			//assertTrue(exception.isAssignableFrom(e.getClass()));
			assertThat(e, new TypeSafeMatcher<Exception>() {

				@Override
				public void describeTo(Description description) {
					description.appendValue(e.getClass()).appendText("cannot be assigned to ").appendValue(exception);
				}

				@Override
				public boolean matchesSafely(Exception actual) {
					return exception.isAssignableFrom(actual.getClass());
				}
			});
		}

	}

	public static interface ThrowsException {

		void throwExcpetion() throws Exception;
	}

}
