package com.thomas.preparation.deque;

public interface Deque<T> {

	void insertFirst(T t);

	void insertLast(T t);

	T removeFirst();

	T removeLast();

	T first();

	T last();

	int size();

	boolean isEmpty();

}
