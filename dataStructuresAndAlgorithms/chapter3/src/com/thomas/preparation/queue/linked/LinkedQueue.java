package com.thomas.preparation.queue.linked;

import com.thomas.preparation.linked.Node;
import com.thomas.preparation.queue.Queue;
import com.thomas.preparation.queue.array.QueueEmptyException;

public class LinkedQueue<T> implements Queue<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public static <T> Queue<T> newLinkedQueue(Class<T> aClass) {
		return new LinkedQueue<T>(null, null, 0);
	}

	private LinkedQueue(Node<T> first, Node<T> tail, int size) {
		this.head = first;
		this.tail = tail;
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
		return head.getValue();
	}

	@Override
	public void enqueue(T t) {
		updateTail();
		tail.setValue(t);
		size++;
	}

	private void updateTail() {
		if (isEmpty()) {
			head = new Node<T>();
			tail = head;
			return;
		}
		Node<T> temp = tail;
		tail = new Node<T>();
		temp.setNext(tail);

	}

	@Override
	public T dequeue() {
		if (isEmpty()) {
			throw new QueueEmptyException();
		}
		size--;
		Node<T> temp = head;
		head = head.getNext();
		return temp.getValue();
	}

}
