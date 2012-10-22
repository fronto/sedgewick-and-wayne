package com.thomas.preparation.queue.array;

public class QueueFullException extends RuntimeException{

	public QueueFullException() {
		super("cannot add elements when queue is full");
	}
	
}
