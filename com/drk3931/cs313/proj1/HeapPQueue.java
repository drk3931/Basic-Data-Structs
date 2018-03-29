/*
 * @Deepak Khemraj
 * drk3931@gmail.com, github.com/drk3931
 * Professor Lapsys, CS313 Project 1
 */
package com.drk3931.cs313.proj1;

public class HeapPQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	T[] dynArray;
	int size = 0, capacity = 10;

	public void grow() {
		capacity *= 2;
		T[] newArr = (T[]) new Comparable[capacity];
		System.arraycopy(dynArray, 0, newArr, 0, dynArray.length);
		dynArray = newArr;
	}

	public HeapPQueue() {
		dynArray = (T[]) new Comparable[capacity];
	}

	@Override
	public void enqueue(T item) {
		size++;
		if (isEmpty()) {
			dynArray[0] = item;
			return;
		}
		if(size == capacity)
		{
			grow();
		}

		// add the new item as leftmost as possible
		dynArray[size - 1] = item;

		int i = size;
		T parent = dynArray[(i / 2) - 1];
		T newNode = dynArray[i - 1];

		if (parent.compareTo(item) < 0) {
			return;
		}

		else // bubble up
		{
			// offset index
			while (i > 1) {
				parent = dynArray[(i / 2) - 1];
				newNode = dynArray[i - 1];

				if (parent.compareTo(item) > 0) {
					// swap parent and child nodes
					T tmp = parent;
					dynArray[(i / 2) - 1] = newNode;
					dynArray[i - 1] = tmp;
					
				}
				
				i /= 2;

			}

		}

	}

	public void printAll() {
		for (int i = 0; i < size; i++) {

			int s = ((Task) dynArray[i]).priority;
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
		
		
		if(size == 0)
		{
			return null;
		}
		
		
		
		
		T ret = dynArray[0];
		
		dynArray[0] = dynArray[size -1 ];
		dynArray[size -1 ] = null;
		if(size > 0)
		{
			size--;
		}
		
		
		
		
		//bubble down
		int i = 1;
		
		//halt at final row
		while ( i < size - 1 )
		{
			
			
			T bubbNode = dynArray[i - 1];
			T left = dynArray[(2 * i) -1];
			T right = dynArray[(2 * i)];
			T tmp;
			
			
			
			if(bubbNode.compareTo(left) <= 0 && bubbNode.compareTo(right) <=0 )
			{
				//finished bubbling
				return ret;
			}
			
			if(bubbNode.compareTo(left) >= 0)
			{
				//swap left
				
				tmp = left;
				dynArray[(2 * i) -1] = dynArray[i - 1];
				dynArray[i - 1] = left;
				
				i*=2;
			}
			
			
		
			else if(bubbNode.compareTo(right) >= 0  )
			{
				//swap right
				
				tmp = right;
				dynArray[(2 * i)] = dynArray[i - 1];
				dynArray[i - 1] = right;
				
				i*=2;
				i++;
				
			}
			
		
			
		
			
				
		}
		
			

		
		return ret;
		
		
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
