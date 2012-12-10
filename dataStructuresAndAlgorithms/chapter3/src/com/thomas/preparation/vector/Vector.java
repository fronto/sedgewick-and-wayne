package com.thomas.preparation.vector;

public interface Vector<T> {

	Integer size();
	
	boolean isEmpty();
	
	T elementAtRank(int rank);

	T replaceAtRank(int rank, T t);

	void insertAtRank(int rank, T t);

	T removeAtRank(int rank);

}
