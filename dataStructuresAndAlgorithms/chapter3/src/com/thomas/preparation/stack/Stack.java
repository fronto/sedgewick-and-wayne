package com.thomas.preparation.stack;

public interface Stack<T> {

	void push(T t);
	
	T pop() throws StackEmptyExcpetion;
	
	int size();
	
	boolean isEmpty();
	
	T top() throws StackEmptyExcpetion;
	
}
