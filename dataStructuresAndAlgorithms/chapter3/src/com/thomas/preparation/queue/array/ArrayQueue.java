package com.thomas.preparation.queue.array;

import java.util.Arrays;

import com.thomas.preparation.queue.Queue;

public class ArrayQueue<T>  implements Queue<T>{

	
	private final T[] array;
	private int front;
	private int next;
	private int size;
	
	
	public static <T> Queue<T> newArrayQueue(T[] emptyArray, int capacity) {
		T[] array = Arrays.copyOf(emptyArray, capacity);
		return new ArrayQueue<T>(array, 0, 0, 0);
	}
	
	private ArrayQueue(T[] array, int front, int next, int size) {
		this.array = array; 
		this.front = front;
		this.next = next;
		this.size = size;
	}
	
	@Override
	public int size() {
		//error when queue is full
		//return array.length - front + next -1;
		return size;
	}

	@Override
	public boolean isEmpty() {
		//error when queue is full
		//return front == next;
		return size == 0;
	}

	@Override
	public T front() {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		return array[front];
	}

	@Override
	public void enqueue(T t) {
		if(isFull()) {
			throw new QueueFullException();
		}
		array[next] = t;
		next = (next + 1) % array.length;
		size++;
	}

	private boolean isFull() {
		return size == array.length;
	}

	@Override
	public T dequeue() {
		if(isEmpty()) {
			throw new QueueEmptyException();
		}
		size--;
		T temp = array[front];
		//encourage early garbage collection
		array[front] = null;
		front = (front + 1) % array.length;
		return temp;
		
	}

}
