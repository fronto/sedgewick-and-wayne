package com.thomas.preparation.queue.test;

import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;
import static com.thomas.preparation.test.TestUtils.expectException;

import org.junit.Test;

import com.thomas.preparation.queue.Queue;
import com.thomas.preparation.queue.array.ArrayQueue;
import com.thomas.preparation.queue.array.QueueEmptyException;
import com.thomas.preparation.queue.array.QueueFullException;
import com.thomas.preparation.test.TestUtils.ThrowsException;

public class QueueTest {

	private static final int FIVE = 5;

	private final QueueFactory<Integer> queueFactory = new QueueFactory<Integer>() {

		@Override
		public Queue<Integer> createQueue() {
			return ArrayQueue.newArrayQueue(new Integer[] {}, FIVE);
		}
	};

	public void firstElementEnqueuedIsAtFront() {
		Queue<Integer> queue = queueFactory.createQueue();
		queue.enqueue(3);
		queue.enqueue(4);
		assertIntegersEqual(queue.front(), 3);

	}

	public void firstElementEnqueuedIsFirstElementDequeued() {
		Queue<Integer> queue = queueFactory.createQueue();
		queue.enqueue(1);
		queue.enqueue(2);

		assertIntegersEqual(queue.dequeue(), 1);

	}

	public void cannotEnqueueWhenQueueFull() {
		expectException(QueueFullException.class, new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Queue<Integer> queue = queueFactory.createQueue();
				for (int i = 0; i < FIVE; i++) {
					queue.enqueue(i);
				}

				queue.enqueue(1);

			}
		});

	}

	public void cannotDequeueWhenQueueIsEmpty() {
		expectException(QueueEmptyException.class, new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Queue<Integer> queue = queueFactory.createQueue();
				queue.dequeue();

			}
		});
	}

	public void cannotQueryFrontWhenQueueIsEmpty() {
		expectException(QueueEmptyException.class, new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Queue<Integer> queue = queueFactory.createQueue();
				queue.dequeue();

			}
		});
	}

	public void enqueueIncrementsSize() {

		Queue<Integer> queue = queueFactory.createQueue();
		queue.enqueue(1);
		queue.enqueue(1);

		assertIntegersEqual(queue.size(), 2);

	}

	public void dequeueDecrementsSize() {
		
		Queue<Integer> queue = queueFactory.createQueue();

		queue.enqueue(1);
		queue.enqueue(1);

		queue.dequeue();

		assertIntegersEqual(queue.size(), 1);

	}

	public void queueWorksAfterBeingFulledThenDrained() {

		Queue<Integer> queue = queueFactory.createQueue();
		QueueClient queueClient = new QueueClient(queue);

		queueClient.enqueue(1);
		queueClient.dequeue(1);

		queueClient.enqueue(2, 3);
		queueClient.dequeue(2).dequeue(3);

		queueClient.enqueue(4, 5, 6);
		queueClient.dequeue(4).dequeue(5).dequeue(6);

		queueClient.enqueue(7, 8, 9, 10);
		queueClient.dequeue(7).dequeue(8).dequeue(9).dequeue(10);

		queueClient.enqueue(11, 12, 13, 14, 15);
		queueClient.dequeue(11).dequeue(12).dequeue(13).dequeue(14).dequeue(15);

	}

	@Test
	public void runQueueTests() {
		firstElementEnqueuedIsAtFront();
		firstElementEnqueuedIsFirstElementDequeued();
		cannotEnqueueWhenQueueFull();
		cannotDequeueWhenQueueIsEmpty();
		cannotQueryFrontWhenQueueIsEmpty();
		enqueueIncrementsSize();
		dequeueDecrementsSize();
		queueWorksAfterBeingFulledThenDrained();
	}

}
