package com.thomas.preparation.queue;

public interface Queue<T> {

	
	int size();
	
	boolean isEmpty();
	
	T front();
	
	void enqueue(T t);
	
	T dequeue();
	
}
