package com.thomas.preparation.queue;

import com.thomas.preparation.deque.Deque;
import com.thomas.preparation.deque.DequeEmptyException;
import com.thomas.preparation.deque.DoublyLinkedList;
import com.thomas.preparation.queue.array.QueueEmptyException;

public class DequeQueueAdapter<T> implements Queue<T> {

	public static <T> Queue<T> newDequeQueueAdapter(Class<T> type) {
		Deque<T> deque = DoublyLinkedList.newDoublyLinkedList(type);
		return new DequeQueueAdapter<T>(deque);
	}
	
	
	private final Deque<T> dequeDelegate;
	
	private DequeQueueAdapter(Deque<T> delegate) {
		this.dequeDelegate = delegate;
	}
	
	@Override
	public int size() {
		return dequeDelegate.size();
	}

	@Override
	public boolean isEmpty() {
		return dequeDelegate.isEmpty();
	}

	@Override
	public T front() {
		return dequeDelegate.last();
	}

	@Override
	public void enqueue(T t) {
		dequeDelegate.insertFirst(t);
	}

	@Override
	public T dequeue() {
		try {
		return dequeDelegate.removeLast();
		} catch(DequeEmptyException empty) {
			throw new QueueEmptyException();
		}
	}
	
}