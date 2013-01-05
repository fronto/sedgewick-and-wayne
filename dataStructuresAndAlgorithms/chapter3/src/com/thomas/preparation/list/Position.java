package com.thomas.preparation.list;

public interface Position<E, P extends Position<E, P>> {

	E element();
	
	P asImplementation();
	
}
