package com.thomas.preparation.vector.test;

import com.thomas.preparation.vector.Vector;
import com.thomas.preparation.vector.VectorEmptyException;

public interface VectorCallback<T> {

	T onVector(Vector<T> vector) throws VectorEmptyException;
	
}
