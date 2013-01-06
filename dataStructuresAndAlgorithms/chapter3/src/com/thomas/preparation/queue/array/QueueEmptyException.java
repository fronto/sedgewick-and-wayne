package com.thomas.preparation.queue.array;

@SuppressWarnings("serial")
public class QueueEmptyException extends Exception {

	public QueueEmptyException() {
		super("cannot remove elements from empty queue");
	}
	
}
