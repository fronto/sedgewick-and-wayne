package com.thomas.preparation.vector.test;

import junit.framework.Assert;

import org.junit.Test;

import com.thomas.preparation.vector.ExtensibleArrayVector;
import com.thomas.preparation.vector.RankOutOfRangeException;
import com.thomas.preparation.vector.Vector;
import com.thomas.preparation.vector.VectorEmptyException;

public class VectorTest {

	@Test
	public void insertAtRankIncreasesSize() {

		VectorClient<Integer> vectorClient = newVector().sizeIs(0);
		vectorClient.insertAtRank(0, 4).sizeIs(1);

	}

	@Test
	public void removeFromRankDecreasesSize() {

		VectorClient<Integer> vectorClient = newVector().insertAtRank(0, 5).sizeIs(1);
		vectorClient.removeAtRank(0).sizeIs(0);

	}

	@Test
	public void emptyWhenSizeIsZero() {

		VectorClient<Integer> vectorClient = newVector().sizeIs(0).isEmpty();
		vectorClient.insertAtRank(0, 4).sizeIsNot(0).isNotEmpty();
		vectorClient.removeAtRank(0).sizeIs(0).isEmpty();

	}

	@Test(expected = VectorEmptyException.class)
	public void cannotRemoveFromEmptyVector() {

		VectorClient<Integer> vectorClient = newVector().sizeIs(0);
		vectorClient.removeAtRank(0);

	}

	@Test(expected = VectorEmptyException.class)
	public void cannotReplaceElementsInEmptyVector() {

		VectorClient<Integer> vectorClient = newVector().sizeIs(0);
		vectorClient.replaceAtRank(0, 4);

	}

	@Test
	public void replacingElementDoesNotChangeSize() {

		VectorClient<Integer> vectorClient = newVector().insertAtRank(0, 2).sizeIs(1);
		vectorClient.replaceAtRank(0, 4).sizeIs(1);

	}

	@Test
	public void insertAtRanksRightShiftsElementsAfterInsert() {

		VectorClient<Integer> vectorClient = newVector().insertAtRank(0, 51487).elementAtRank(0, 51487);
		vectorClient.insertAtRank(0, 2).elementAtRank(1, 51487);

	}

	@Test
	public void removeAtRankLeftShiftsElemmentsAfterInsert() {

		VectorClient<Integer> vectorClient = newVector().insertAtRank(0, 0).elementAtRank(0, 0).insertAtRank(1, 1)
				.elementAtRank(1, 1);
		vectorClient.removeAtRank(0).elementAtRank(0, 1);

	}

	@Test(expected = RuntimeException.class)
	public void cannotRemoveElementGreaterThanSize() {

		VectorClient<Integer> vectorClient = newVector().insertAtRank(0, 0).sizeIs(1);
		vectorClient.removeAtRank(1);

	}

	@Test(expected = RankOutOfRangeException.class)
	public void cannotRetrieveElementGreaterOrEqualToSize() {

		VectorClient<Integer> vectorClient = newVector().insertAtRank(0, 0).sizeIs(1);
		vectorClient.elementAtRank(1, 1);
		
	}

	private VectorClient<Integer> newVector() {
		Vector<Integer> vector = ExtensibleArrayVector.newExtensibleArrayVector(new Integer[] {});
		VectorClient<Integer> vectorClient = new VectorClient<Integer>(vector);
		return vectorClient;
	}

	@Test
	public void canQueryIsEmpty() {

		VectorClient<Integer> vectorClient = newVector();
		vectorClient.sizeIs(0).isEmpty();

		vectorClient.insertAtRank(0, 1).isNotEmpty();
	}

	@Test
	public void canRetireveElementAtRank() {

		VectorClient<Integer> vectorClient = newVector();
		vectorClient.insertAtRank(0, 5).elementAtRank(0, is(5));
		vectorClient.insertAtRank(1, 4).elementAtRank(1, is(4));

	}

	private <I> I is(I i) {
		return i;
	}

	@Test
	public void canReplaceAtRank() {

		VectorClient<Integer> vectorClient = newVector();
		vectorClient.insertAtRank(0, 5);
		vectorClient.ensure(replaceAtRank(0, 6), returns(5)).elementAtRank(0, 6);

	}

	private VectorCallbackResult<Integer> returns(final Integer i) {
		return new VectorCallbackResult<Integer>() {

			@Override
			public VectorClient<Integer> processResult(Integer result, VectorClient<Integer> vectorClient) {
				Assert.assertEquals(i, result);
				return vectorClient;
			}
		};
	}

	private VectorCallback<Integer> replaceAtRank(final int rank, final int t) {
		return new VectorCallback<Integer>() {

			@Override
			public Integer onVector(Vector<Integer> vector) {
				return vector.replaceAtRank(rank, t);
			}
		};
	}


}
