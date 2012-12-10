package com.thomas.preparation.vector.test;

import com.thomas.preparation.vector.Vector;

public interface VectorCallback<T> {

	T onVector(Vector<T> vector);
	
}
