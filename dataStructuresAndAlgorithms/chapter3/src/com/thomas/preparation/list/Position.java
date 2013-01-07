package com.thomas.preparation.list;

public interface Position<E> {

	E element();
	
	<P extends Position<E>> P asImplementation(Class<P> implementationClass);
	
}
