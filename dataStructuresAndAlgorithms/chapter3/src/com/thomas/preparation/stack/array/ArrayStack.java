package com.thomas.preparation.stack.array;

import java.util.Arrays;

import com.thomas.preparation.stack.Stack;
import com.thomas.preparation.stack.StackEmptyExcpetion;

public class ArrayStack<T> implements  Stack<T>{

	
	public static <T> ArrayStack<T> newArrayStack(int capacity, T[] emptyArray) {
		T[] typedArray = Arrays.copyOf(emptyArray, capacity);
		if(typedArray.length != capacity) {
			throw new IllegalStateException("underlying array does not have required capacity");
		}
		return new ArrayStack<T>(typedArray, -1);
	}
	
	private final T[] elements;
	private int index;
	
	private ArrayStack(T[] elements, int index) {
		if(index != -1) {
			throw new IllegalArgumentException("starting index must be -1");
		}
		this.elements = elements;
		this.index = index;
	}
	
	
	@Override
	public void push(T t) {
		index++;
		elements[index] = t;
	}

	@Override
	public T pop() throws StackEmptyExcpetion {
		if(isEmpty()) {
			throw new StackEmptyExcpetion();
		}
		
		T temp = elements[index];
		elements[index] = null;
		index--;
		return temp;
		
	}

	@Override
	public int size() {
		return index+1;
	}

	@Override
	public boolean isEmpty() {
		return index == -1;
	}

	@Override
	public T top() throws StackEmptyExcpetion {
		if(isEmpty()) {
			throw new StackEmptyExcpetion();
		}
		return elements[index];
	}

}
