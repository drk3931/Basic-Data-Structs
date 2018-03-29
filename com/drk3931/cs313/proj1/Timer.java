/*
 * @Deepak Khemraj
 * drk3931@gmail.com, github.com/drk3931
 * Professor Lapsys, CS313 Project 1
 */
package com.drk3931.cs313.proj1;

public class Timer {

	long elapsed;
	long start;
	
	public void begin()
	{
		start = System.currentTimeMillis();
	}
	public long end()
	{
		elapsed = System.currentTimeMillis() - start;
		return elapsed;
	}
	
}
