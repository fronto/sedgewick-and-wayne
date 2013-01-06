package com.thomas.preparation.vector.test;

import org.junit.Assert;

import com.thomas.preparation.vector.Vector;
import com.thomas.preparation.vector.VectorEmptyException;

public class VectorClient<T> {

	private final Vector<T> vector;

	public VectorClient(Vector<T> vector) {
		this.vector = vector;
	}

	public VectorClient<T> sizeIs(Integer i) {
		Assert.assertEquals(i, vector.size());
		return this;
	}

	public VectorClient<T> isEmpty() {
		Assert.assertTrue(vector.isEmpty());
		return this;
	}

	public VectorClient<T> elementAtRank(int rank, T expected) throws VectorEmptyException {
		Assert.assertEquals(expected, vector.elementAtRank(rank));
		return this;
	}

	public VectorClient<T> replaceAtRank(int rank, T t) throws VectorEmptyException {
		vector.replaceAtRank(rank, t);
		return this;
	}

	public VectorClient<T> insertAtRank(int rank, T t) {
		vector.insertAtRank(rank, t);
		return this;
	}

	public VectorClient<T> removeAtRank(final int rank) throws VectorEmptyException {
		vector.removeAtRank(rank);
		return this;

	}

	public VectorClient<T> ensure(VectorCallback<T> vectorCallback, VectorCallbackResult<T> onResult) throws VectorEmptyException {
		T result = vectorCallback.onVector(vector);
		return onResult.processResult(result, this);
	}

	public VectorClient<T> isNotEmpty() {
		Assert.assertFalse(vector.isEmpty());
		return this;
	}

	public VectorClient<T> sizeIsNot(Integer i) {
			Assert.assertFalse(vector.size().equals(i));
			return this;
		
	}

}
