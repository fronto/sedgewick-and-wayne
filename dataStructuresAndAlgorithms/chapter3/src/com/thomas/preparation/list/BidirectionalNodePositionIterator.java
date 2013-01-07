package com.thomas.preparation.list;

import com.thomas.preparation.deque.BiderectionalNode;

public class BidirectionalNodePositionIterator<T> implements PositionIterator<T, BiderectionalNode<T>> {

	private BiderectionalNode<T> current;

	public static <E> BidirectionalNodePositionIterator<E> newBidirectionalNodePositionIterator(
			BiderectionalNode<E> start) {
		BiderectionalNode<E> sentinel = new BiderectionalNode<E>();
		sentinel.setNext(start);
		return new BidirectionalNodePositionIterator<E>(sentinel);
	}

	private BidirectionalNodePositionIterator(BiderectionalNode<T> current) {
		this.current = current;
	}

	@Override
	public boolean hasNextPosition() {
		return current.getNext() != null;
	}

	@Override
	public BiderectionalNode<T> getNextPosition() {
		current = current.getNext();
		return current;
	}

}
