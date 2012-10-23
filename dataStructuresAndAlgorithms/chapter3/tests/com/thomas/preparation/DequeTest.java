package com.thomas.preparation;

import static com.thomas.preparation.test.TestUtils.assertIntegersEqual;

import org.junit.Test;

import com.thomas.preparation.deque.Deque;
import com.thomas.preparation.deque.DoublyLinkedList;

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

}
