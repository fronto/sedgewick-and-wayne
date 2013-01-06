package com.thomas.preparation.vector;

public interface Vector<T> {

	Integer size();
	
	boolean isEmpty();
	
	T elementAtRank(int rank) throws VectorEmptyException;

	T replaceAtRank(int rank, T t) throws VectorEmptyException;

	void insertAtRank(int rank, T t);

	T removeAtRank(int rank) throws VectorEmptyException;

}
