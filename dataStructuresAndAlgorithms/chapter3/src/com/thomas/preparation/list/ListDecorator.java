package com.thomas.preparation.list;

public class ListDecorator<T>  implements List<T> {

	private final List<T> delegate;
	
	public ListDecorator(List<T> delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public boolean isFirst(Position<T> position) throws InvalidPositionException, EmptyListException {
		return delegate.isFirst(position);
	}

	@Override
	public boolean isLast(Position<T> position) throws InvalidPositionException, EmptyListException {
		return delegate.isLast(position);
	}

	@Override
	public Position<T> first() throws EmptyListException {
		return delegate.first();
	}

	@Override
	public Position<T> last() throws EmptyListException {
		return delegate.last();
	}

	@Override
	public Position<T> before(Position<T> position) throws InvalidPositionException, BoundaryViolationException, EmptyListException {
		return delegate.before(position);
	}

	@Override
	public Position<T> after(Position<T> position) throws InvalidPositionException, BoundaryViolationException, EmptyListException {
		return delegate.after(position);
	}

	@Override
	public Position<T> insertBefore(Position<T> position, T element) throws InvalidPositionException {
		return delegate.insertBefore(position, element);
	}

	@Override
	public Position<T> insertAfter(Position<T> position, T element) throws InvalidPositionException {
		return delegate.insertAfter(position, element);
	}

	@Override
	public Position<T> insertFirst(T element) throws InvalidPositionException {
		return delegate.insertFirst(element);
	}

	@Override
	public Position<T> insertLast(T element) throws InvalidPositionException {
		return delegate.insertLast(element);
	}

	@Override
	public T remove(Position<T> position) throws InvalidPositionException, EmptyListException {
		return delegate.remove(position);
	}

	@Override
	public T replaceElement(Position<T> position, T element) throws InvalidPositionException {
		return delegate.replaceElement(position, element);
	}

	@Override
	public void swapElements(Position<T> positionA, Position<T> positionB) throws InvalidPositionException {
		delegate.swapElements(positionA, positionB);
	}

}
