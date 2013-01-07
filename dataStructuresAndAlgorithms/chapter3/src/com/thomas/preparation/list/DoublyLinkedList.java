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
	public boolean isFirst(Position<T> position) throws InvalidPositionException, EmptyListException {
		checkNotEmpty();
		return position == header;
	}

	@Override
	public boolean isLast(Position<T> position) throws InvalidPositionException, EmptyListException {
		checkNotEmpty();
		return position == trailer;
	}

	private void checkNotEmpty() throws EmptyListException {
		if (isEmpty()) {
			throw new EmptyListException();
		}
	}

	@Override
	public Position<T> before(Position<T> position)
			throws InvalidPositionException, BoundaryViolationException {
		BiderectionalNode<T> positionNode = asNode(position);
		if (positionNode == header) {
			throw new BoundaryViolationException();
		}
		return positionNode.getPrevious();
	}

	@SuppressWarnings("unchecked")
	private BiderectionalNode<T> asNode(Position<T> position) {
		return position.asImplementation(BiderectionalNode.class);
	}

	@Override
	public Position<T> after(Position<T> position)
			throws InvalidPositionException, BoundaryViolationException {
		BiderectionalNode<T> positionNode = asNode(position);
		if (position == trailer) {
			throw new BoundaryViolationException();
		}

		return positionNode.getNext();
	}

	@Override
	public Position<T> insertBefore(Position<T> position, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> positionNode = asNode(position);
		BiderectionalNode<T> newNode = new BiderectionalNode<T>();
		newNode.setValue(element);

		BiderectionalNode<T> prev = positionNode.getPrevious();
		prev.setNext(newNode);
		newNode.setPrevious(prev);

		newNode.setNext(positionNode);
		positionNode.setPrevious(newNode);

		size++;

		return newNode;

	}

	@Override
	public Position<T> insertAfter(Position<T> position, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> positionNode = asNode(position);
		BiderectionalNode<T> newNode = new BiderectionalNode<T>();
		newNode.setValue(element);

		BiderectionalNode<T> next = positionNode.getNext();
		newNode.setNext(next);
		next.setPrevious(newNode);

		positionNode.setNext(newNode);
		newNode.setPrevious(positionNode);

		size++;

		return newNode;
	}

	@Override
	public Position<T> insertFirst(Position<T> position, T element)
			throws InvalidPositionException {

		//TODO check this method
		BiderectionalNode<T> positionNode = asNode(position);
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
	public Position<T> insertLast(Position<T> positon, T element)
			throws InvalidPositionException {

		BiderectionalNode<T> positionNode = asNode(positon);
		trailer.setNext(positionNode);
		positionNode.setPrevious(trailer);
		trailer = positionNode;

		size++;
		
		return trailer;
	}

	@Override
	public T remove(Position<T> position) throws InvalidPositionException {
		BiderectionalNode<T> positionNode = asNode(position);
		checkContainsReference(positionNode);
		BiderectionalNode<T> previous = positionNode.getPrevious();
		BiderectionalNode<T> next = positionNode.getNext();

		previous.setNext(next);
		next.setPrevious(previous);
		size--;

		checkDoesNotCountain(position);

		return position.element();

	}

	private void checkDoesNotCountain(Position<T> position) {
		if (containsPositionReference(position)) {
			throw new IllegalStateException("contains position");
		}
	}

	private void checkContainsReference(Position<T> position) {
		if (containsPositionReference(position)) {
			return;
		}
		throw new IllegalArgumentException("position not present in list");
	}

	@Override
	public T replaceElement(Position<T> position, T element) throws InvalidPositionException {
		checkContainsReference(position);
		BiderectionalNode<T> positionNode = asNode(position);
		
		T oldValue = position.element();
		positionNode.setValue(element);
		return oldValue;
	}

	@Override
	public void swapElements(Position<T> positionA, Position<T> positionB)
			throws InvalidPositionException {
		// TODO do elements have to be adjacent
		BiderectionalNode<T> nodeA = asNode(positionA);
		BiderectionalNode<T> befpreA = nodeA.getPrevious();
		BiderectionalNode<T> afterA = nodeA.getNext();

		BiderectionalNode<T> nodeB = asNode(positionB);
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
	public Position<T> first() throws EmptyListException {
		checkNotEmpty();
		return header;
	}


	@Override
	public Position<T> last() throws EmptyListException {
		checkNotEmpty();
		return trailer;
	}

	private boolean containsPositionReference(Position<T> position) {
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
