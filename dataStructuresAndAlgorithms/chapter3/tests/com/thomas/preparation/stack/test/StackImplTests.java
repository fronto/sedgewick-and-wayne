package com.thomas.preparation.stack.test;

import org.junit.Test;

import com.thomas.preparation.stack.DequeStackAdapter;
import com.thomas.preparation.stack.Stack;
import com.thomas.preparation.stack.array.ArrayStack;
import com.thomas.preparation.stack.linked.LinkedStack;

public class StackImplTests {

	private static final int TEN = 10;
	
	private static Integer[] integers() {
		return new Integer[] {};
	}
	
	
	
	@Test
	public void testArrayStack() {
		
		StackFactory<Integer> arrayStackFactory = new StackFactory<Integer>() {
			
			@Override
			public Stack<Integer> createStack() {
				return ArrayStack.newArrayStack(TEN, integers());
			}
		};
		
		StackTester stackTester = new StackTester(arrayStackFactory);
		stackTester.runStackTests();
		
	}
	
	
	@Test
	public void testLinkedStack() {
		StackFactory<Integer> linkedStackFactory = new StackFactory<Integer>() {

			@Override
			public Stack<Integer> createStack() {
				return LinkedStack.newLinkedStack(Integer.class);
			}
			
		};
		
		StackTester stackTester = new StackTester(linkedStackFactory);
		stackTester.runStackTests();
	}
	
	@Test
	public void testDequeStackAdapter() {
		StackFactory<Integer> dequeStackFactory = new StackFactory<Integer>() {
			
			@Override
			public Stack<Integer> createStack() {
				return DequeStackAdapter.newDequeStackAdapter(Integer.class);
			}
		};
		StackTester stackTester = new StackTester(dequeStackFactory);
		stackTester.runStackTests();
	}
	
}