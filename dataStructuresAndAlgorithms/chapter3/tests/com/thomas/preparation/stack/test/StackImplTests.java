package com.thomas.preparation.stack.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.thomas.preparation.stack.Stack;
import com.thomas.preparation.stack.StackEmptyExcpetion;
import com.thomas.preparation.stack.array.ArrayStack;


public class StackImplTests {

	private static final int TEN = 10;


	@Test
	public void popReturnsLastValuePushed() {
	
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(2);
		stack.push(5);
		assertIntegersEqual(5, stack.pop());
		
	}
	
	
	@Test(expected=StackEmptyExcpetion.class)
	public void popThrowsExceptionWhenStackIsEmpty() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.pop();
	}
	
	
	private static void assertIntegersEqual(int actual, int expected) {
		assertEquals(Integer.valueOf(actual), Integer.valueOf(expected));
	}


	private static Integer[] integers() {
		return new Integer[] {};
	}


	@Test
	public void lastPushedIsTopOfStack() {
		

		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(2);
		stack.push(5);
		
		assertIntegersEqual(5, stack.top());
		
		
	}
	
	@Test
	public void topReturnsLastValuePushed() {

		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(2);
		
		assertIntegersEqual(2, stack.top());
		
		
	}
	
	
	@Test(expected=StackEmptyExcpetion.class) 
	public void topThrowsExceptionWhenStackIsEmpty() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.top();
	}
	
	@Test
	public void pushIncrementsSize() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(1);
		stack.push(1);
		assertIntegersEqual(stack.size(), 2);
	}
	
	@Test
	public void popDecrementsSize() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(1);
		stack.push(1);
		stack.pop();
		assertIntegersEqual(stack.size(), 1);
		
	}
	
	
	@Test
	public void isEmptyOnNewStack() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		assertTrue(stack.isEmpty());
	}
	
	
	@Test
	public void isEmptyAfterPushThenPop() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(2);
		stack.pop();
		assertTrue(stack.isEmpty());
	}

	@Test
	public void notEmptyOnStackWithElements() {
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(1);
		assertFalse(stack.isEmpty());
		
	}
		
	
	
}
