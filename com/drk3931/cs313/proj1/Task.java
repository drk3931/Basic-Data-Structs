package com.drk3931.cs313.proj1;
/*
 * @Author Adolfas Lapsys
 */
class Task implements Comparable<Task> {
	public int id;
	public int priority;

	public int compareTo(Task other) {
		return other.priority - this.priority;
	}
	public Task(int id, int priority)
	{
		this.id = id;
		this.priority = priority;
	}
}