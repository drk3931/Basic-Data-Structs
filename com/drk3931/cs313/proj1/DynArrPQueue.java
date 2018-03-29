/*
 * @Deepak Khemraj
 * drk3931@gmail.com, github.com/drk3931
 * Professor Lapsys, CS313 Project 1
 */

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
		if(size == capacity)
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
		return dynArray[0];
	}

	@Override
	public T dequeue() {
		
		if(isEmpty())
		{
			return null;
		}
		
		if(needsSorting)
		{
			try
			{
				Arrays.sort(dynArray);
			}
			catch (Exception e) //transitive comparison problem
			{}
			needsSorting = false;
		}
		T tmp = dynArray[0];
		
		T[] newArr =(T[]) new Comparable[capacity - 1];
		System.arraycopy(dynArray, 1, newArr, 0, dynArray.length -2);
		
		return tmp;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return dynArray[0] == null;
	}

}
