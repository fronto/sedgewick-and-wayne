package com.thomas.preparation.list;

@SuppressWarnings("serial")
public class EmptyListException extends RuntimeException {

	public EmptyListException() {
		super("empty container exception");
	}
	
}
