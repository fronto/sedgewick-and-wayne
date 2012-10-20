package com.thomas.preparation.stack;

import java.util.ArrayList;
import java.util.List;


public class ArrayStack<T> implements  Stack<T>{

	
	public static <T> ArrayStack<T> newArrayStack(int capacity, T[] emptyArray) {
		List<T> list = new ArrayList<T>(capacity);
		T[] typedArray = list.toArray(emptyArray);
		return new ArrayStack<T>(typedArray);
	}
	
	private final T[] elements;
	
	private ArrayStack(T[] elements) {
		this.elements = elements;
	}
	
	
	@Override
	public void push(T t) {
		
	}

	@Override
	public T pop() throws StackEmptyExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T top() throws StackEmptyExcpetion {
		// TODO Auto-generated method stub
		return null;
	}

}
