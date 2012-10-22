package com.thomas.preparation.queue.array;

public class QueueEmptyException extends RuntimeException {

	public QueueEmptyException() {
		super("cannot remove elements from empty queue");
	}
	
}
