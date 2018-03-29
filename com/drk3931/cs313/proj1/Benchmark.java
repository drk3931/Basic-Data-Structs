/*
 * @Deepak Khemraj
 * drk3931@gmail.com, github.com/drk3931
 * Professor Lapsys, CS313 Project 1
 */
package com.drk3931.cs313.proj1;

import java.util.Random;

public class Benchmark {

	Timer timer = new Timer();
	Random randy = new Random();

	public long benchmarkEnqueue(PriorityQueue p, int n) {
		timer.begin();
		for (int i = 0; i < n; i++) {
			p.enqueue(new Task(randy.nextInt(), randy.nextInt()));
		}
		return timer.end();

	}

	public long benchmarkDequeue(PriorityQueue p, int n) {
		timer.begin();
		for (int i = 0; i < n; i++) {
			p.dequeue();
		}
		return timer.end();

	}

	public long benchmarkDequeueEnqueue(PriorityQueue p, int n) {
		
		timer.begin();
		boolean randomBool = randy.nextBoolean();

		for (int i = 0; i < n; i++) {
			if (randomBool) {
				p.enqueue(new Task(randy.nextInt(), randy.nextInt()));
			} else
				p.dequeue();
		}
		return timer.end();
	}

}
