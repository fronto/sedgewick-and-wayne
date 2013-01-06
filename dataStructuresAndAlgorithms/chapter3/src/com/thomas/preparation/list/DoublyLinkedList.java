package com.thomas.preparation.list;

import com.thomas.preparation.deque.BiderectionalNode;

public class DoublyLinkedList<T> implements List<T, BiderectionalNode<T>> {

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

	private DoublyLinkedList(BiderectionalNode<T> header, BiderectionalNode<T> trailer, int size) {
		this.header = header;
		this.trailer = trailer;
		this.size = size;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean isFirst(Position<T, BiderectionalNode<T>> position) throws InvalidPositionException, EmptyListException {
		checkNotEmpty();
		return position == header;
	}

	@Override
	public boolean isLast(Position<T, BiderectionalNode<T>> position) throws InvalidPositionException, EmptyListException {
		checkNotEmpty();
		return position == trailer;
	}

	private void checkNotEmpty() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
	}

	@Override
	public Position<T, BiderectionalNode<T>> before(Position<T, BiderectionalNode<T>> position)
			throws InvalidPositionException, BoundaryViolationException {
		if (position == header) {
			throw new BoundaryViolationException();
		}
		return position.asImplementation().getPrevious();
	}

	@Override
	public Position<T, BiderectionalNode<T>> after(Position<T, BiderectionalNode<T>> position)
			throws InvalidPositionException, BoundaryViolationException {
		if (position == trailer) {
			throw new BoundaryViolationException();
		}

		return position.asImplementation().getNext();
	}

	@Override
	public Position<T, BiderectionalNode<T>> insertBefore(Position<T, BiderectionalNode<T>> position, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> newNode = new BiderectionalNode<T>();
		newNode.setValue(element);

		BiderectionalNode<T> prev = position.asImplementation().getPrevious();
		prev.setNext(newNode);
		newNode.setPrevious(prev);

		newNode.setNext(position.asImplementation());
		position.asImplementation().setPrevious(newNode);

		size++;

		return newNode;

	}

	@Override
	public Position<T, BiderectionalNode<T>> insertAfter(Position<T, BiderectionalNode<T>> position, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> newNode = new BiderectionalNode<T>();
		newNode.setValue(element);

		BiderectionalNode<T> next = position.asImplementation().getNext();
		newNode.setNext(next);
		next.setPrevious(newNode);

		position.asImplementation().setNext(newNode);
		newNode.setPrevious(position.asImplementation());

		size++;

		return newNode;
	}

	@Override
	public Position<T, BiderectionalNode<T>> insertFirst(Position<T, BiderectionalNode<T>> position, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> newHeader = new BiderectionalNode<T>();
		newHeader.setNext(header);
		header.setPrevious(newHeader);

		header = newHeader;

		size++;

		return header;
	}

	// @Override
	// public void insertLast(T t) {
	//
	// BiderectionalNode<T> secondLast = trailer.getPrevious();
	//
	// BiderectionalNode<T> last = new BiderectionalNode<T>();
	// last.setValue(t);
	//
	//
	// last.setNext(trailer);
	// last.setPrevious(secondLast);
	//
	// secondLast.setNext(last);
	// trailer.setPrevious(last);
	//
	// size++;
	//
	// }

	@Override
	public Position<T, BiderectionalNode<T>> insertLast(Position<T, BiderectionalNode<T>> positon, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> positionNode = positon.asImplementation();
		trailer.setNext(positionNode);
		positionNode.setPrevious(trailer);
		trailer = positionNode;

		size++;
		
		return trailer;
	}

	@Override
	public T remove(Position<T, BiderectionalNode<T>> position) throws InvalidPositionException {
		BiderectionalNode<T> positionNode = position.asImplementation();
		checkContainsReference(positionNode);
		BiderectionalNode<T> previous = positionNode.getPrevious();
		BiderectionalNode<T> next = positionNode.getNext();

		previous.setNext(next);
		next.setPrevious(previous);
		size--;

		checkDoesNotCountain(position);

		return position.element();

	}

	private void checkDoesNotCountain(Position<T, BiderectionalNode<T>> position) {
		if (containsPositionReference(position)) {
			throw new IllegalStateException("contains position");
		}
	}

	private void checkContainsReference(Position<T, BiderectionalNode<T>> position) {
		if (containsPositionReference(position)) {
			return;
		}
		throw new IllegalArgumentException("position not present in list");
	}

	@Override
	public T replaceElement(Position<T, BiderectionalNode<T>> position, T element) throws InvalidPositionException {
		checkContainsReference(position);
		T oldValue = position.element();
		position.asImplementation().setValue(element);
		return oldValue;
	}

	@Override
	public void swapElements(Position<T, BiderectionalNode<T>> positionA, Position<T, BiderectionalNode<T>> positionB)
			throws InvalidPositionException {
		// TODO do elements have to be adjacent
		BiderectionalNode<T> nodeA = positionA.asImplementation();
		BiderectionalNode<T> befpreA = nodeA.getPrevious();
		BiderectionalNode<T> afterA = nodeA.getNext();

		BiderectionalNode<T> nodeB = positionB.asImplementation();
		BiderectionalNode<T> beforeB = nodeB.getPrevious();
		BiderectionalNode<T> afterB = nodeB.getNext();

		nodeA.setNext(afterB);
		afterB.setPrevious(nodeA);

		nodeA.setPrevious(beforeB);
		beforeB.setNext(nodeA);

		nodeB.setNext(afterA);
		afterA.setPrevious(nodeB);

		nodeB.setPrevious(befpreA);
		befpreA.setNext(nodeB);

		// TODO check all permutations
		// case A-B -> B-A
		// case B-A -> A-B
		// case A-E-B -> B-E-A
		// case B-E-A -> A-E-B
		// case A-A -> AA

	}

	@Override
	public Position<T, BiderectionalNode<T>> first() throws EmptyListException {
		checkNotEmpty();
		return header;
	}


	@Override
	public Position<T, BiderectionalNode<T>> last() throws EmptyListException {
		checkNotEmpty();
		return trailer;
	}

	private boolean containsPositionReference(Position<T, BiderectionalNode<T>> position) {
		PositionIterator<T, BiderectionalNode<T>> positions = positionIterator();
		while (positions.hasNextPosition()) {
			// TODO improve reference equality
			if (position == positions.getNextPosition()) {
				return true;
			}
		}
		return false;
	}

	private PositionIterator<T, BiderectionalNode<T>> positionIterator() {
		return BidirectionalNodePositionIterator.newBidirectionalNodePositionIterator(header);

	}

}
