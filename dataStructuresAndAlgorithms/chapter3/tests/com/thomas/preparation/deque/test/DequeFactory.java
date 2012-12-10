package com.thomas.preparation.deque.test;

import com.thomas.preparation.deque.Deque;


public interface DequeFactory<T> {

	Deque<T> createDeque();
	
}
