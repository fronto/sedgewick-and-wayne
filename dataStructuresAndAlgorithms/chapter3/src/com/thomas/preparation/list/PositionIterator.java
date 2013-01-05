package com.thomas.preparation.list;

public interface PositionIterator<T, P extends Position<T, P>> {

	boolean hasNextPosition();
	
	Position<T, P> getNextPosition();
	
}
