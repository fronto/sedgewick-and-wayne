package com.thomas.preparation.deque;

public interface Deque<T> {

	void insertFirst(T t);

	void insertLast(T t);

	T removeFirst() throws DequeEmptyException;

	T removeLast() throws DequeEmptyException;

	T first() throws DequeEmptyException;

	T last() throws DequeEmptyException;

	int size();

	boolean isEmpty();

}
