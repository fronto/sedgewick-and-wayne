package com.thomas.preparation.stack;

@SuppressWarnings("serial")
public class StackEmptyExcpetion extends Exception {

	public StackEmptyExcpetion() {
		super("cannot retrieve element from empty stack");
	}
	
}
