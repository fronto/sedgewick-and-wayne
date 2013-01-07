package com.thomas.preparation.list;

public interface List<E> {

	int size();

	boolean isEmpty();

	boolean isFirst(Position<E> position) throws InvalidPositionException, EmptyListException;

	boolean isLast(Position<E> position) throws InvalidPositionException, EmptyListException;

	Position<E> first() throws EmptyListException;

	Position<E> last() throws EmptyListException;

	Position<E> before(Position<E> position) throws InvalidPositionException, BoundaryViolationException;

	Position<E> after(Position<E> position) throws InvalidPositionException, BoundaryViolationException;

	Position<E> insertBefore(Position<E> position, E element) throws InvalidPositionException;

	Position<E> insertAfter(Position<E> position, E element) throws InvalidPositionException;

	Position<E> insertFirst(Position<E> position, E element) throws InvalidPositionException;

	Position<E> insertLast(Position<E> positon, E element) throws InvalidPositionException;

	E remove(Position<E> position) throws InvalidPositionException;

	E replaceElement(Position<E> position, E element) throws InvalidPositionException;

	void swapElements(Position<E> positionA, Position<E> positionB) throws InvalidPositionException;
}
