package com.thomas.preparation.queue.test;

import org.junit.Test;

import com.thomas.preparation.queue.Queue;
import com.thomas.preparation.queue.array.ArrayQueue;
import com.thomas.preparation.queue.linked.LinkedQueue;

public class QueueImplTests {

	private static final int FIVE = 5;

	@Test
	public void testArrayQueue() {
		QueueFactory<Integer> queueFactory = new QueueFactory<Integer>() {

			@Override
			public Queue<Integer> createQueue() {
				return ArrayQueue.newArrayQueue(new Integer[] {}, FIVE);
			}
		};

		QueueTester queueTester = new QueueTester(queueFactory);
		queueTester.runQueueTests();
	}

	
	@Test
	public void testLinkedQueue() {
		QueueFactory<Integer> queueFactory = new QueueFactory<Integer>() {

			@Override
			public Queue<Integer> createQueue() {
				return LinkedQueue.newLinkedQueue(Integer.class);
			}
		};

		QueueTester queueTester = new QueueTester(queueFactory);
		queueTester.runQueueTests();
	}	
	
	
}
