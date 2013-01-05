package com.thomas.preparation.deque;

import com.thomas.preparation.list.Position;

public class BiderectionalNode<T> implements Position<T, BiderectionalNode<T>> {

	private BiderectionalNode<T> next;
	private BiderectionalNode<T> previous;
	private T value;
	
	public BiderectionalNode() {
	}

	public BiderectionalNode<T> getNext() {
		return next;
	}

	public void setNext(BiderectionalNode<T> next) {
		this.next = next;
	}

	public BiderectionalNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(BiderectionalNode<T> previous) {
		this.previous = previous;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public T element() {
		return getValue();
	}

	@Override
	public BiderectionalNode<T> asImplementation() {
		return this;
	}
	
	
}
