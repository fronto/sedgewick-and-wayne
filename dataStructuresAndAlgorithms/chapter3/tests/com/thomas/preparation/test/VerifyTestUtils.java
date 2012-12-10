package com.thomas.preparation.test;

import static com.thomas.preparation.test.TestUtils.expectException;

import org.junit.Test;

import com.thomas.preparation.test.TestUtils.ThrowsException;

public class VerifyTestUtils {

	@Test
	public void throwException() {
		
		expectException(Exception.class, new ThrowsException() {
			
			@Override
			public void throwExcpetion() throws Exception {
				throw new RuntimeException();
			}
		});
		
	}
	
	
}
