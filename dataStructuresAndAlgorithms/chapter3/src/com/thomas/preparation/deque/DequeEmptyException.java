package com.thomas.preparation.deque;

@SuppressWarnings("serial")
public class DequeEmptyException extends RuntimeException {

	public DequeEmptyException() {
		super("cannot remove from empty deque");
	}
	
	
}
