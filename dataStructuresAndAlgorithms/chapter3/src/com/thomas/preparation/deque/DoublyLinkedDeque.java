package com.thomas.preparation.deque;

public class DoublyLinkedDeque<T> implements Deque<T> {

	private BiderectionalNode<T> header;
	private BiderectionalNode<T> trailer;
	private int size;

	public static <T> DoublyLinkedDeque<T> newDoublyLinkedDeque(Class<T> aClass) {
		BiderectionalNode<T> header = new BiderectionalNode<T>();
		BiderectionalNode<T> trailer = new BiderectionalNode<T>();
		header.setNext(trailer);
		trailer.setPrevious(header);
		return new DoublyLinkedDeque<T>(header, trailer, 0);
	}

	private DoublyLinkedDeque(BiderectionalNode<T> header,
			BiderectionalNode<T> trailer, int size) {
		this.header = header;
		this.trailer = trailer;
		this.size = size;
	}

	@Override
	public void insertFirst(T t) {
		// setup node
		BiderectionalNode<T> first = new BiderectionalNode<T>();
		first.setValue(t);

		BiderectionalNode<T> second = header.getNext();
		
		// setup node's links
		first.setNext(second);
		first.setPrevious(header);

		// header's old next's previous and then header's next
		second.setPrevious(first);
		header.setNext(first);

		// update size
		size++;
	}

	@Override
	public void insertLast(T t) {
		
		BiderectionalNode<T> secondLast = trailer.getPrevious();
		
		BiderectionalNode<T> last = new BiderectionalNode<T>();
		last.setValue(t);

		
		last.setNext(trailer);
		last.setPrevious(secondLast);

		secondLast.setNext(last);
		trailer.setPrevious(last);

		size++;

	}

	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new DequeEmptyException();
		}

		size--;

		BiderectionalNode<T> toRemove = header.getNext();
		toRemove.getNext().setPrevious(header);
		header.setNext(toRemove.getNext());
		return toRemove.getValue();
	}

	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new DequeEmptyException();
		}

		size--;

		BiderectionalNode<T> toRemove = trailer.getPrevious();
		toRemove.getPrevious().setNext(trailer);
		trailer.setPrevious(toRemove.getPrevious());
		return toRemove.getValue();
	}

	@Override
	public T first() throws DequeEmptyException {
		if(isEmpty()) {
			throw new DequeEmptyException();
		}
		BiderectionalNode<T> first = header.getNext();
		return first.getValue();
		
	}

	@Override
	public T last() throws DequeEmptyException {
		if(isEmpty()) {
			throw new DequeEmptyException();
		}
		BiderectionalNode<T> last = trailer.getPrevious();
		return last.getValue();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
