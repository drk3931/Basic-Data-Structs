package com.drk3931.cs313.proj1;

import java.util.Arrays;

public class DynArrPQueue<T extends Comparable<T>> implements PriorityQueue<T> {
	
	
	T[] dynArray;
	int size = 0,capacity = 10;
	boolean needsSorting = false;
	
	@SuppressWarnings("unchecked")
	public DynArrPQueue() {
		dynArray =(T[]) new Comparable[capacity];
	}
	
	public void grow()
	{
		capacity*=2;
		T[] newArr =(T[]) new Comparable[capacity];
		System.arraycopy(dynArray, 0, newArr, 0, dynArray.length);
		dynArray = newArr;
	}
	
	
	@Override
	public void enqueue(T item) {
		size++; 
		if(size > capacity)
		{
			grow();
		}
		dynArray[size -1] = item;
		needsSorting = true; 
		
	}
	
	public void printAll()
	{
		for(int i = 0; i < size; i++)
		{
			
			int s = ((Task)dynArray[i]).priority;
			System.out.println(s);
			
		}
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T dequeue() {
		
		if(needsSorting)
		{
			Arrays.sort(dynArray);
			needsSorting = false;
		}
		return dynArray[0];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
