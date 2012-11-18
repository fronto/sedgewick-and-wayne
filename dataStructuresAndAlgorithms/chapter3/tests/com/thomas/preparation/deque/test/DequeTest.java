package com.thomas.preparation.deque.test;

import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;
import static com.thomas.preparation.test.TestUtils.expectException;

import org.junit.Test;

import com.thomas.preparation.deque.Deque;
import com.thomas.preparation.deque.DequeEmptyException;
import com.thomas.preparation.deque.DoublyLinkedList;
import com.thomas.preparation.test.TestUtils.ThrowsException;

public class DequeTest {

	private static final int FIVE = 5;
	private static final Integer ONE = 1;

	@Test
	public void canAppendToFrontOfDeque() {
		Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
		deque.insertFirst(ONE);
		deque.insertFirst(FIVE);
		assertIntegersEqual(deque.first(), FIVE);
	}

	@Test
	public void canAppendToEndOFDeque() {
		Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
		deque.insertLast(ONE);
		deque.insertLast(FIVE);
		assertIntegersEqual(deque.last(), FIVE);
	}

	@Test
	public void canRemoveFirst() {
		Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
		deque.insertFirst(ONE);
		deque.insertFirst(FIVE);

		assertIntegersEqual(deque.removeFirst(), FIVE);
		assertIntegersEqual(deque.size(), ONE);
	}

	@Test
	public void canRemoveLast() {
		Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
		deque.insertLast(ONE);
		deque.insertLast(FIVE);

		assertIntegersEqual(deque.removeLast(), FIVE);
		assertIntegersEqual(deque.size(), ONE);

	}
	
	@Test
	public void cannotQueryEmptyDeque() {
		expectException(DequeEmptyException.class, queryingFirst());
		expectException(DequeEmptyException.class, queryingLast());
	}
	
	@Test
	public void cannotRemoveFromEmptyDeque() {
		expectException(DequeEmptyException.class, removingFirst());
		expectException(DequeEmptyException.class, removingLast());
	}

	private ThrowsException removingLast() {
		return new ThrowsException() {
			
			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
				deque.removeLast();
			}
		};
	}

	private ThrowsException removingFirst() {
		return new ThrowsException() {
			
			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
				deque.removeFirst();
			}
		};
	}

	private ThrowsException queryingLast() {
		return new ThrowsException() {
			
			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
				deque.last();
			}
		};
	}

	private ThrowsException queryingFirst() {
		return new ThrowsException() {
			
			@Override
			public void throwExcpetion() {
				Deque<Integer> deque = DoublyLinkedList.newDoublyLinkedList(Integer.class);
				deque.first();
			}
		};
	}

}
