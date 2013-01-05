package com.thomas.preparation.list;

public interface List<E, P extends Position<E,P>> {

	int size();

	boolean isEmpty();

	boolean isFirst(Position<E, P> position) throws InvalidPositionException;

	boolean isLast(Position<E, P> position) throws InvalidPositionException;

	Position<E, P> first() throws EmptyListException;

	Position<E, P> last() throws EmptyListException;

	Position<E, P> before(Position<E, P> position) throws InvalidPositionException, BoundaryViolationException;

	Position<E, P> after(Position<E, P> position) throws InvalidPositionException, BoundaryViolationException;

	Position<E, P> insertBefore(Position<E, P> position, E element) throws InvalidPositionException;

	Position<E, P> insertAfter(Position<E, P> position, E element) throws InvalidPositionException;

	Position<E, P> insertFirst(Position<E, P> position, E element) throws InvalidPositionException;

	Position<E, P> insertLast(Position<E, P> positon, E element) throws InvalidPositionException;

	E remove(Position<E, P> position) throws InvalidPositionException;

	E replaceElement(Position<E, P> position, E element) throws InvalidPositionException;

	void swapElements(Position<E, P> positionA, Position<E, P> positionB) throws InvalidPositionException;
}
