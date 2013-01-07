package com.thomas.preparation.list;

public interface PositionIterator<T, P extends Position<T>> {

	boolean hasNextPosition();
	
	P getNextPosition();
	
}
