package com.thomas.preparation.stack.test;

import org.junit.Test;

import com.thomas.preparation.stack.ArrayStack;
import com.thomas.preparation.stack.Stack;
import static org.junit.Assert.*;


public class StackImplTests {

	private static final int TEN = 10;


	@Test
	public void popReturnsLastValuePushed() {
	
		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(2);
		stack.push(5);
		assertIntegersEqual(5, stack.pop());
		
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
	public void canQueryTop() {

		Stack<Integer> stack = ArrayStack.newArrayStack(TEN, integers());
		stack.push(2);
		
		assertIntegersEqual(2, stack.top());
		
		
	}
	
	@Test
	public void obtainsSizeCorrecty() {
		
		
		
		
	}
	
	
	@Test
	public void canQueryIsEmpty() {
		
		//returnsTrueOnEmtyStack();
		//returnFalseOnStackWithElements();
		
	}
	
	
}
