package com.thomas.preparation.deque;

public class DoublyLinkedList<T> implements Deque<T> {

	private BiderectionalNode<T> header;
	private BiderectionalNode<T> trailer;
	private int size;

	public static <T> DoublyLinkedList<T> newDoublyLinkedList(Class<T> aClass) {
		BiderectionalNode<T> header = new BiderectionalNode<T>();
		BiderectionalNode<T> trailer = new BiderectionalNode<T>();
		header.setNext(trailer);
		trailer.setPrevious(header);
		return new DoublyLinkedList<T>(header, trailer, 0);
	}

	private DoublyLinkedList(BiderectionalNode<T> header,
			BiderectionalNode<T> trailer, int size) {
		this.header = header;
		this.trailer = trailer;
		this.size = size;
	}

	@Override
	public void insertFirst(T t) {
		// setup node
		BiderectionalNode<T> node = new BiderectionalNode<T>();
		node.setValue(t);

		// setup node's links
		node.setNext(header.getNext());
		node.setPrevious(header);

		// header's old next's previous and then header's next
		header.getNext().setPrevious(node);
		header.setNext(node);

		// update size
		size++;
	}

	@Override
	public void insertLast(T t) {
		BiderectionalNode<T> node = new BiderectionalNode<T>();
		node.setValue(t);

		node.setNext(trailer);
		node.setPrevious(trailer.getPrevious());

		trailer.getPrevious().setNext(node);
		trailer.setPrevious(node);

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
	public T first() {
		BiderectionalNode<T> first = header.getNext();
		return first.getValue();
	}

	@Override
	public T last() {
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
