/*
 * @Deepak Khemraj
 * drk3931@gmail.com, github.com/drk3931
 * Professor Lapsys, CS313 Project 1
 */
package com.drk3931.cs313.proj1;

import java.util.Random;

public class PriorityQueueTesting {
	
	LListPQueue llPQueue = new LListPQueue<Task>();
	DynArrPQueue dynPQueue = new DynArrPQueue<Task>();
	HeapPQueue 	heapPQueue = new HeapPQueue<Task>();
	Benchmark benchmark = new Benchmark();
	
	
	public PriorityQueueTesting()
	{
		
		for(int i = 0; i <= 50000; i+=10000)
		{	
			
			//enque here before deque test
			
			int allTrials = 0;
			for(int j= 0; j < 10; j++)
			{
				
				//benchmark here.
				
				//allTrials+=benchmark.benchmarkDequeueEnqueue(heapPQueue,i);
				
			}
			int average = allTrials/10;
			System.out.println(allTrials);
		}
				
	
	}

}
