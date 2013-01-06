package com.thomas.preparation.vector;

@SuppressWarnings("serial")
public class VectorEmptyException extends Exception {

	public VectorEmptyException() {
			super("cannot retrieve from empty vector");
	}
	
}
