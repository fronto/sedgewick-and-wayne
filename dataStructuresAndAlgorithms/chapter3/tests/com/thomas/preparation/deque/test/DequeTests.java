package com.thomas.preparation.deque.test;

import org.junit.Test;

import com.thomas.preparation.deque.Deque;
import com.thomas.preparation.deque.DoublyLinkedDeque;
import com.thomas.preparation.deque.VectorDeque;
import com.thomas.preparation.vector.ExtensibleArrayVector;
import com.thomas.preparation.vector.Vector;

public class DequeTests {

	
	@Test
	public void doublyLinkedDequeWorks() {
		runDequeTests(new DequeFactory<Integer>() {

			@Override
			public Deque<Integer> createDeque() {
				return DoublyLinkedDeque.newDoublyLinkedDeque(Integer.class);
			}
		});
	}
	
	private void runDequeTests(DequeFactory<Integer> dequeFactory) {
		DequeTester dequeTester = new DequeTester(dequeFactory);
		dequeTester.runTests();
	}

	@Test
	public void extendableArrayDequeWorks() {
		runDequeTests(new DequeFactory<Integer>() {

			@Override
			public Deque<Integer> createDeque() {
				Vector<Integer> vector = ExtensibleArrayVector.newExtensibleArrayVector(new Integer[] {});
				return new VectorDeque<Integer>(vector);
			}
		});		
	}
	
}
