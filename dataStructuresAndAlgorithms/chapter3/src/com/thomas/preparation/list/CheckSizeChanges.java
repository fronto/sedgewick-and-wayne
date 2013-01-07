package com.thomas.preparation.list;

public class CheckSizeChanges<T> extends ListDecorator<T> {

	public CheckSizeChanges(List<T> delegate) {
		super(delegate);
	}

	@Override
	public boolean isEmpty() {
		assert (super.isEmpty() && size() == 0) || (!super.isEmpty() && size() > 0);
		try {
			return super.isEmpty();
		} finally {
			assert (super.isEmpty() && size() == 0) || (!super.isEmpty() && size() > 0);
		}

	}

	@Override
	public boolean isFirst(Position<T> position) throws InvalidPositionException, EmptyListException {
		assert size() > 0 || super.isEmpty();
		try {
			return super.isFirst(position);

		} catch (EmptyListException e) {
			assert super.size() == 0 && super.isEmpty();
			throw e;
		} finally {
			assert size() > 0 || super.isEmpty();
		}

	}

	@Override
	public boolean isLast(Position<T> position) throws InvalidPositionException, EmptyListException {
		assert size() > 0 || super.isEmpty();
		try {
			return super.isLast(position);

		} catch (EmptyListException e) {
			assert super.size() == 0 && super.isEmpty();
			throw e;
		} finally {
			assert size() > 0 || super.isEmpty();
		}
	}

	@Override
	public Position<T> first() throws EmptyListException {
		assert size() > 0 || super.isEmpty();
		try {
			return super.first();
		} catch (EmptyListException e) {
			assert super.size() == 0 && super.isEmpty();
			throw e;
		} finally {
			assert size() > 0 || super.isEmpty();
		}
	}

	@Override
	public Position<T> last() throws EmptyListException {
		assert size() > 0 || super.isEmpty();
		try {
			return super.last();
		} catch (EmptyListException e) {
			assert super.size() == 0 && super.isEmpty();
			throw e;
		} finally {
			assert size() > 0 || super.isEmpty();
		}
	}

	@Override
	public Position<T> before(Position<T> position) throws InvalidPositionException, BoundaryViolationException,
			EmptyListException {
		assert size() > 0 || super.isEmpty();
		try {
			return super.before(position);
		} catch (EmptyListException e) {
			assert super.size() == 0 && super.isEmpty();
			throw e;
		} finally {
			assert size() > 0 || super.isEmpty();
		}
	}

	@Override
	public Position<T> after(Position<T> position) throws InvalidPositionException, BoundaryViolationException,
			EmptyListException {
		assert size() > 0 || super.isEmpty();
		try {
			return super.before(position);
		} catch (EmptyListException e) {
			assert super.size() == 0 && super.isEmpty();
			throw e;
		} finally {
			assert size() > 0 || super.isEmpty();
		}
	}

	@Override
	public Position<T> insertBefore(Position<T> position, T element) throws InvalidPositionException {
		assert (size()) > 0 && !super.isEmpty();
		int sizeBefore = size();
		try {
			return super.insertBefore(position, element);
		} finally {
			int sizeAfter = size();
			assert sizeAfter == sizeBefore + 1;
		}
	}

	@Override
	public Position<T> insertAfter(Position<T> position, T element) throws InvalidPositionException {
		assert (size()) > 0 && !super.isEmpty();
		int sizeBefore = size();
		try {
			return super.insertAfter(position, element);
		} finally {
			int sizeAfter = size();
			assert sizeAfter == sizeBefore + 1;
		}
	}

	@Override
	public Position<T> insertFirst(T element) throws InvalidPositionException {
		int sizeBefore = size();
		try {
			return super.insertFirst(element);
		} finally {
			int sizeAfter = size();
			assert sizeAfter == sizeBefore + 1;
		}
	}

	@Override
	public Position<T> insertLast(T element) throws InvalidPositionException {
		int sizeBefore = size();
		try {
			return super.insertLast(element);
		} finally {
			int sizeAfter = size();
			assert sizeAfter == sizeBefore + 1;
		}
	}

	@Override
	public T remove(Position<T> position) throws InvalidPositionException, EmptyListException {
		boolean notEmpty = size() > 0 && !super.isEmpty();
		int sizeBefore = size();
		try {
			T result = super.remove(position);
			assert notEmpty;
			return result;
		} catch(EmptyListException e) {
			assert !notEmpty;
			throw e;
		} finally {
			int sizeAfter = size();
			assert sizeAfter == sizeBefore - 1;
		}
	}

	@Override
	public T replaceElement(Position<T> position, T element) throws InvalidPositionException {
		assert size() > 0 && !super.isEmpty();
		int sizeBefore = size();
		try {
			return super.replaceElement(position, element);
		} finally {
			assert size() > 0 && !super.isEmpty();
			int sizeAfter = size();
			assert sizeBefore == sizeAfter;
		}
		
	}

	@Override
	public void swapElements(Position<T> positionA, Position<T> positionB) throws InvalidPositionException {
		assert !super.isEmpty() && (positionA == positionB || super.size() <= 2);
		int sizeBefore = size();
		try {
			super.swapElements(positionA, positionB);
		} finally {
			int sizeAfter = size();
			assert sizeBefore == sizeAfter;
		}
	}
	

}
