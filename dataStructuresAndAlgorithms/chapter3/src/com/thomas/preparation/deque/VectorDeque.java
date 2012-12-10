package com.thomas.preparation.deque;

import com.thomas.preparation.vector.Vector;
import com.thomas.preparation.vector.VectorEmptyException;

public class VectorDeque<T> implements Deque<T> {

	private Vector<T> vector;

	public VectorDeque(Vector<T> vector) {
		this.vector = vector;
	}

	@Override
	public void insertFirst(T t) {
		vector.insertAtRank(0, t);
	}

	@Override
	public void insertLast(T t) {
		vector.insertAtRank(size(), t);
	}

	@Override
	public T removeFirst() throws DequeEmptyException {
		try {
			return vector.removeAtRank(0);
		} catch (VectorEmptyException empty) {
			throw new DequeEmptyException();
		}
	}

	@Override
	public T removeLast() throws DequeEmptyException {
		try {
		return vector.removeAtRank(size() - 1);
		} catch(VectorEmptyException e) {
			throw new DequeEmptyException();
		}
		
	}

	@Override
	public T first() throws DequeEmptyException {
		try {
			return vector.elementAtRank(0);
		} catch (VectorEmptyException vectorEmpty) {
			throw new DequeEmptyException();
		}
	}

	@Override
	public T last() throws DequeEmptyException {
		try {
			return vector.elementAtRank(vector.size() - 1);
		} catch (VectorEmptyException empty) {
			throw new DequeEmptyException();
		}
	}

	@Override
	public int size() {
		return vector.size();
	}

	@Override
	public boolean isEmpty() {
		return vector.isEmpty();
	}

}
