package com.thomas.preparation.queue.test;

import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;

import org.junit.Before;
import org.junit.Test;

import com.thomas.preparation.queue.Queue;
import com.thomas.preparation.queue.array.ArrayQueue;
import com.thomas.preparation.queue.array.QueueEmptyException;
import com.thomas.preparation.queue.array.QueueFullException;

public class QueueTest {

	private static final int FIVE = 5;

	private Queue<Integer> queue = ArrayQueue.newArrayQueue(new Integer[] {}, FIVE);

	@Before
	public void refreshQueue() {
		queue = ArrayQueue.newArrayQueue(new Integer[] {}, FIVE);
	}

	@Test
	public void firstElementEnqueuedIsAtFront() {

		queue.enqueue(3);
		queue.enqueue(4);
		assertIntegersEqual(queue.front(), 3);

	}

	@Test
	public void firstElementEnqueuedIsFirstElementDequeued() {

		queue.enqueue(1);
		queue.enqueue(2);

		assertIntegersEqual(queue.dequeue(), 1);

	}

	@Test(expected = QueueFullException.class)
	public void cannotEnqueueWhenQueueFull() {

		for (int i = 0; i < FIVE; i++) {
			queue.enqueue(i);
		}

		queue.enqueue(1);

	}

	@Test(expected = QueueEmptyException.class)
	public void cannotDequeueWhenQueueIsEmpty() {
		queue.dequeue();
	}

	@Test(expected = QueueEmptyException.class)
	public void cannotQueryFrontWhenQueueIsEmpty() {
		queue.dequeue();
	}

	@Test
	public void enqueueIncrementsSize() {
		
		queue.enqueue(1);
		queue.enqueue(1);
		
		assertIntegersEqual(queue.size(), 2);
		
	}

	@Test
	public void dequeueDecrementsSize() {

		queue.enqueue(1);
		queue.enqueue(1);
		
		queue.dequeue();
		
		assertIntegersEqual(queue.size(), 1);
		
		
	}

	@Test
	public void queueWorksAfterBeingFulledThenDrained() {

		QueueClient queueClient = new QueueClient(queue);
		
		queueClient.enqueue(1);
		queueClient.dequeue(1);
		
		queueClient.enqueue(2,3);
		queueClient.dequeue(2).dequeue(3);
		
		queueClient.enqueue(4,5,6);
		queueClient.dequeue(4).dequeue(5).dequeue(6);
		
		queueClient.enqueue(7,8,9,10);
		queueClient.dequeue(7).dequeue(8).dequeue(9).dequeue(10);
		
		queueClient.enqueue(11,12,13,14,15);
		queueClient.dequeue(11).dequeue(12).dequeue(13).dequeue(14).dequeue(15);
		
		
	}

}
