package com.thomas.preparation.stack;

import com.thomas.preparation.deque.Deque;
import com.thomas.preparation.deque.DequeEmptyException;
import com.thomas.preparation.deque.DoublyLinkedList;

public class DequeStackAdapter<T> implements Stack<T> {

	public static <T> Stack<T> newDequeStackAdapter(Class<T> type) {
		Deque<T> deque = DoublyLinkedList.newDoublyLinkedList(type);
		return new DequeStackAdapter<T>(deque);
	}
	
	private final Deque<T> dequeDelegate;

	private DequeStackAdapter(Deque<T> dequeDelegate) {
		this.dequeDelegate = dequeDelegate;
	}

	@Override
	public void push(T t) {
		dequeDelegate.insertFirst(t);
	}

	@Override
	public T pop() throws StackEmptyExcpetion {
		try {
			return dequeDelegate.removeFirst();
		} catch (DequeEmptyException empty) {
			throw new StackEmptyExcpetion();
		}
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
	public T top() throws StackEmptyExcpetion {
		try {
		return dequeDelegate.first();
		} catch(DequeEmptyException emptyDeque) {
			throw new StackEmptyExcpetion();
		}
	}

}
