package com.thomas.preparation.deque.test;

import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;
import static com.thomas.preparation.test.TestUtils.expectException;

import com.thomas.preparation.deque.Deque;
import com.thomas.preparation.deque.DequeEmptyException;
import com.thomas.preparation.test.TestUtils.ThrowsException;

public class DequeTester {

	private static final int FIVE = 5;
	private static final Integer ONE = 1;

	private DequeFactory<Integer> dequeFactory;
	
	public DequeTester(DequeFactory<Integer> dequeFactory) {
		this.dequeFactory = dequeFactory;
	}
	
	private void canAppendToFrontOfDeque() {
		Deque<Integer> deque = dequeFactory.createDeque();
		deque.insertFirst(ONE);
		deque.insertFirst(FIVE);
		assertIntegersEqual(deque.first(), FIVE);
	}

	private void canAppendToEndOFDeque() {
		Deque<Integer> deque = dequeFactory.createDeque();
		deque.insertLast(ONE);
		deque.insertLast(FIVE);
		assertIntegersEqual(deque.last(), FIVE);
	}

	private void canRemoveFirst() {
		Deque<Integer> deque = dequeFactory.createDeque();
		deque.insertFirst(ONE);
		deque.insertFirst(FIVE);

		assertIntegersEqual(deque.removeFirst(), FIVE);
		assertIntegersEqual(deque.size(), ONE);
	}

	private void canRemoveLast() {
		Deque<Integer> deque = dequeFactory.createDeque();
		deque.insertLast(ONE);
		deque.insertLast(FIVE);

		assertIntegersEqual(deque.removeLast(), FIVE);
		assertIntegersEqual(deque.size(), ONE);

	}

	private void cannotQueryEmptyDeque() {
		expectException(DequeEmptyException.class, queryingFirst());
		expectException(DequeEmptyException.class, queryingLast());
	}

	private void cannotRemoveFromEmptyDeque() {
		expectException(DequeEmptyException.class, removingFirst());
		expectException(DequeEmptyException.class, removingLast());
	}

	private ThrowsException removingLast() {
		return new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = dequeFactory.createDeque();
				deque.removeLast();
			}
		};
	}

	private ThrowsException removingFirst() {
		return new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = dequeFactory.createDeque();
				deque.removeFirst();
			}
		};
	}

	private ThrowsException queryingLast() {
		return new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = dequeFactory.createDeque();
				deque.last();
			}
		};
	}

	private ThrowsException queryingFirst() {
		return new ThrowsException() {

			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = dequeFactory.createDeque();
				deque.first();
			}
		};
	}

	void runTests() {
		canAppendToFrontOfDeque();
		canAppendToEndOFDeque();
		canRemoveFirst();
		canRemoveLast();
		cannotQueryEmptyDeque();
		cannotRemoveFromEmptyDeque();
	}

}
