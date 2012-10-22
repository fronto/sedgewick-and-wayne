package com.thomas.preparation.stack.test;

import com.thomas.preparation.stack.Stack;

public interface StackFactory<T> {

	Stack<T> createStack();
	
	
}
