package com.thomas.preparation.queue.test;

import com.thomas.preparation.queue.Queue;
import com.thomas.preparation.queue.array.QueueEmptyException;

import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;
public class QueueClient {

	private final Queue<Integer> queue;
	
	public QueueClient(Queue<Integer> queue) {
		this.queue = queue;
	}
	
	
	QueueClient enqueue(Integer... ints) {
		for(int i : ints) {
			queue.enqueue(i);
		}
		return this;
	}
	
	
	QueueClient dequeue(int expected) throws QueueEmptyException {
		assertIntegersEqual(queue.dequeue(), expected);
		return this;
	}
	
	QueueClient hasSize(int size) {
		assertIntegersEqual(queue.size(), size);
		return this;
	}
	
	
}
