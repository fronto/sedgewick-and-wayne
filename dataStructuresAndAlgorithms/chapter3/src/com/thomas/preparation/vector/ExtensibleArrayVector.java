package com.thomas.preparation.vector;

import java.util.Arrays;

public class ExtensibleArrayVector<T> implements Vector<T> {

	private static final int INITIAL_CAPACITY = 16;
	private T[] array;
	private int size;
	private int capacity;

	public static <T> Vector<T> newExtensibleArrayVector(T[] emptyArray) {
		T[] realEmptyArray = Arrays.copyOf(emptyArray, 0);
		int capacity = INITIAL_CAPACITY;
		T[] array = Arrays.copyOf(realEmptyArray, capacity);
		return new ExtensibleArrayVector<T>(array, 0, capacity);

	}

	private ExtensibleArrayVector(T[] array, int size, int capacity) {
		check(size, is(0));
		check(capacity, is(array.length));

		this.array = array;
		this.size = size;
		this.capacity = capacity;
	}

	private static int is(int i) {
		return i;
	}

	private void check(int size2, int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public T elementAtRank(int rank) throws VectorEmptyException {
		if(isEmpty()) {
			throw new VectorEmptyException();
		}
		
		if(rank >= size) {
			throw new RankOutOfRangeException();
		}
		return array[rank];
	}

	@Override
	public T replaceAtRank(int rank, T t) throws VectorEmptyException {
		if(isEmpty()) {
			throw new VectorEmptyException();
		}
		if(rank >= size) {
			throw new RankOutOfRangeException();
		}
		T temp = array[rank];
		array[rank] = t;
		return temp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insertAtRank(int rank, T t) {
		if(size == capacity) {
			capacity = capacity * 2;
			T[] temp = (T[]) new Object[capacity];
			for(int i = 0; i < size; i++) {
				temp[i] = array[i];
			}
			array = temp;
		}
		for(int i = size -1; i >= rank; i--) {
			array[i+1] = array[i];
		}
		array[rank] = t;
		size++;
	}

	@Override
	public T removeAtRank(int rank) throws VectorEmptyException {

		if(isEmpty()) {
			throw new VectorEmptyException();
		}
		
		if (rank >= size) {
			throw new RankOutOfRangeException();
		}
		
		T temp = array[rank];
		for (int i = rank; i < size - 1; i++) {
			array[i] = array[i + 1];
		}
		size--;
		return temp;
	}

}
