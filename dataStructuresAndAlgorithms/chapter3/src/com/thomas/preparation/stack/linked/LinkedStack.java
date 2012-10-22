package com.thomas.preparation.stack.linked;

import com.thomas.preparation.linked.Node;
import com.thomas.preparation.stack.Stack;
import com.thomas.preparation.stack.StackEmptyExcpetion;

public class LinkedStack<T> implements Stack<T>{

	private Node<T> top;
	private int count;
	
	
	public static <T> Stack<T> newLinkedStack(Class<T> aClass) {
		return new LinkedStack<T>(null, 0);
	}
	
	private LinkedStack(Node<T> top, int count) {
		if(count != 0) {
			throw new IllegalArgumentException("initial count must be 0");
		}
		if(top != null) {
			throw new IllegalArgumentException("top must be null");
		}
			this.top = top;
			this.count = count;
	}
	
	@Override
	public void push(T t) {
		Node<T> temp = top;
		top = new Node<T>();
		top.setValue(t);
		top.setNext(temp);
		count++;
	}

	@Override
	public T pop() throws StackEmptyExcpetion {
		if(isEmpty()) {
			throw new StackEmptyExcpetion();
		}
		Node<T> temp = top;
		top = top.getNext();
		count--;
		return temp.getValue();
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public T top() throws StackEmptyExcpetion {
		if(isEmpty()) {
			throw new StackEmptyExcpetion();
		}
		return top.getValue();
	}

}
