package com.thomas.preparation.queue.linked;

import com.thomas.preparation.linked.Node;
import com.thomas.preparation.queue.Queue;
import com.thomas.preparation.queue.array.QueueEmptyException;

public class LinkedQueue<T> implements Queue<T> {

	private Node<T> front;
	private int size;

	public static <T> Queue<T> newLinkedQueue(Class<T> aClass) {
		return new LinkedQueue<T>(null, 0);
	}
	
	private LinkedQueue(Node<T> first, int size) {
		this.front = first;
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T front() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		return front.getValue();
	}

	@Override
	public void enqueue(T t) {
		size++;
		Node<T> last = front;
		if (front == null) {
			front = new Node<T>();
			front.setValue(t);
			return;
		}
		while (last.getNext() != null) {
			last = last.getNext();
		}
		Node<T> temp = last;
		last = new Node<T>();
		last.setValue(t);
		temp.setNext(last);
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		size--;
		Node<T> temp = front;
		front = front.getNext();
		return temp.getValue();
	}

}
