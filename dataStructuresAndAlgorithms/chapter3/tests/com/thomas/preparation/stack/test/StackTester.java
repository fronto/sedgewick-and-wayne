package com.thomas.preparation.stack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.thomas.preparation.stack.Stack;
import com.thomas.preparation.stack.StackEmptyExcpetion;

public class StackTester {

	
	private final StackFactory<Integer> stackFactory;

	public StackTester(StackFactory<Integer> stackFactory) {
		this.stackFactory = stackFactory;
	}
	
	private void popReturnsLastValuePushed() {

		Stack<Integer> stack = stackFactory.createStack();
		stack.push(2);
		stack.push(5);
		assertIntegersEqual(5, stack.pop());

	}

	
	private void popThrowsExceptionWhenStackIsEmpty() {

		expectException(StackEmptyExcpetion.class, new ThrowsException() {

			@Override
			public void throwExcpetion() {

				Stack<Integer> stack = stackFactory.createStack();
				stack.pop();

			}
		});

	}

	private static void assertIntegersEqual(int actual, int expected) {
		assertEquals(Integer.valueOf(actual), Integer.valueOf(expected));
	}

	

	
	private void lastPushedIsTopOfStack() {

		Stack<Integer> stack = stackFactory.createStack();
		stack.push(2);
		stack.push(5);

		assertIntegersEqual(5, stack.top());

	}

	
	private void topReturnsLastValuePushed() {

		Stack<Integer> stack = stackFactory.createStack();
		stack.push(2);

		assertIntegersEqual(2, stack.top());

	}

	
	private void topThrowsExceptionWhenStackIsEmpty() {
		expectException(StackEmptyExcpetion.class, new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Stack<Integer> stack = stackFactory.createStack();
				stack.top();
			}
		});

	}

	
	private void pushIncrementsSize() {
		Stack<Integer> stack = stackFactory.createStack();
		stack.push(1);
		stack.push(1);
		assertIntegersEqual(stack.size(), 2);
	}

	
	private void popDecrementsSize() {
		Stack<Integer> stack = stackFactory.createStack();
		stack.push(1);
		stack.push(1);
		stack.pop();
		assertIntegersEqual(stack.size(), 1);

	}

	
	private void isEmptyOnNewStack() {
		Stack<Integer> stack = stackFactory.createStack();
		assertTrue(stack.isEmpty());
	}

	
	private void isEmptyAfterPushThenPop() {
		Stack<Integer> stack = stackFactory.createStack();
		stack.push(2);
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	
	private void notEmptyOnStackWithElements() {
		Stack<Integer> stack = stackFactory.createStack();
		stack.push(1);
		assertFalse(stack.isEmpty());

	}

	private static <E extends Exception> void expectException(
			Class<E> exception, ThrowsException throwing) {
		try {

			throwing.throwExcpetion();
			fail("expected exception not thrown");

		} catch (Exception e) {
			assertTrue(exception.isAssignableFrom(e.getClass()));
		}

	}

	private static interface ThrowsException {

		void throwExcpetion();
	}

	public void runStackTests() {
	  popReturnsLastValuePushed(); 
	  popThrowsExceptionWhenStackIsEmpty(); 
	  lastPushedIsTopOfStack(); 
	  topReturnsLastValuePushed(); 
	  topThrowsExceptionWhenStackIsEmpty(); 
	  pushIncrementsSize(); 
	  popDecrementsSize(); 
	  isEmptyOnNewStack(); 
	  isEmptyAfterPushThenPop(); 
	  notEmptyOnStackWithElements(); 
	}
}

