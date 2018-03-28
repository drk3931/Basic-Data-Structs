package com.drk3931.cs313.proj1;

public class LListPQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	class LNode<T> {
		public T data;
		public LNode next = null;
		public LNode prev = null;

		public LNode(T data) {
			this.data = data;
		}
	}

	LNode<T> head;
	LNode<T> tail;
	int size;

	@Override
	public void enqueue(T item) {

		size++;
		LNode nodeptr = head;
		LNode newNode = new LNode(item);

		if (head == null) {
			head = new LNode(item);
			return;
		}

		int nodePriority = ((Task) nodeptr.data).priority;
		int newNodePriority = ((Task) newNode.data).priority;

		if (nodePriority < newNodePriority) {
			LNode tmp = head;
			head = newNode;
			head.next = tmp;
			tmp.prev = head;
			return;
		}

		if (nodePriority > newNodePriority) {
			
			if(head.next == null)
			{
				head.next = newNode;
				newNode.prev = head;
				return;
			}

			//Halt at the node directly before the new nodes insertion point.
			while (((Task) nodeptr.next.data).priority > newNodePriority) {
				nodeptr = nodeptr.next;
				
				
				//Deal with an edge case where the task has lowest priority of all. 
				if(nodeptr.next == null)
				{
					nodeptr.next = newNode;
					newNode.prev = nodeptr;
					tail = newNode;
					return;
				}
			}

			LNode tmp = nodeptr.next;
			nodeptr.next = newNode;
			newNode.next = tmp;
			newNode.prev = nodeptr;
			
		}

	}

	public void printAll() {
		LNode nodeptr = head;
		while (nodeptr != null) {
		    System.out.println(((Task)nodeptr.data).priority);
			nodeptr = nodeptr.next;
		}

	}

	@Override
	public T peek() {
		return head.data;
	}

	@Override
	public T dequeue() {
		LNode tmp = head;
		if(head != null)
		{
			head = head.next;
		}
		size--;
		return (T) tmp.data;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}
