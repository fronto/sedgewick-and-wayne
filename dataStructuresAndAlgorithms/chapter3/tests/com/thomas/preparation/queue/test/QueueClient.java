package com.thomas.preparation.queue.test;

import com.thomas.preparation.queue.Queue;
import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;
public class QueueClient {

	private final Queue<Integer> queue;
	
	public QueueClient(Queue<Integer> queue) {
		this.queue = queue;
	}
	
	
	void enqueue(Integer... ints) {
		for(int i : ints) {
			queue.enqueue(i);
		}
	}
	
	
	QueueClient dequeue(int expected) {
		assertIntegersEqual(queue.dequeue(), expected);
		return this;
	}
	
	
}
