package com.drk3931.cs313.proj1;

import java.util.Random;

public class PriorityQueueTesting {
	
	LListPQueue llPQueue;
	DynArrPQueue dynPQueue;
	HeapPQueue heapPQueue;
	
	Random randy = new Random();
	
	public PriorityQueueTesting()
	{
		
		
		dynPQueue = new DynArrPQueue<Task>();
		for(int i = 0; i < 10; i++)
		{
			dynPQueue.enqueue(new Task(i, randy.nextInt() % 10));

		}
		dynPQueue.printAll();
		System.out.println();

		System.out.println(((Task)dynPQueue.dequeue()).priority);
		
		
		//heapPQueue = new HeapPQueue<Task>();
	}

}
