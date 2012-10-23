package com.thomas.preparation.queue.test;

import com.thomas.preparation.queue.Queue;

public interface QueueFactory<T> {

	Queue<T> createQueue();
	
}
