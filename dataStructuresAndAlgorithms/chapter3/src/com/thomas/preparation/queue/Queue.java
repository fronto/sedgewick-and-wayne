package com.thomas.preparation.queue;

import com.thomas.preparation.queue.array.QueueEmptyException;

public interface Queue<T> {

	
	int size();
	
	boolean isEmpty();
	
	T front() throws QueueEmptyException;
	
	void enqueue(T t);
	
	T dequeue() throws QueueEmptyException;
	
}
