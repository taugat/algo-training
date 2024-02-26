package com.etsugo.algotraining;

public class LinkedList<T> {
	
	static class Node<T>
	{
		private Node<T> next;
		private T value;
		
		public Node<T> getNext() {
			return next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value2) {
			value = value2;
		}

		public void setNext(Node<T> node) {
			next = node;
		}
	}
	
	private Node<T> head = null;
	private Node<T> tail = null;

	public boolean isEmpty()
	{
		return null == head;
	}
	
	public T get(int index)
	{
		Node<T> node = head;
		
		for (int i = 0; node != null && i < index; i++)
		{
			node = node.getNext();
		}
		
		if (null == node)
		{
			throw new IndexOutOfBoundsException();
		}
		else
		{
			return node.getValue();
		}
	}
	
	public void add(T value)
	{
		Node<T> node = new Node<>();
		
		node.setValue(value);
		
		if (isEmpty())
		{
			head = node;
		}
		else
		{
			tail.setNext(node);
		}
		
		tail = node;
	}
	
	public boolean remove(T value)
	{
		boolean removed = false;
		
		if (!isEmpty())
		{
			Node<T> prevNode = null;
			Node<T> node = head;
			while (node != tail && value != node)
			{
				prevNode = node;
				node = node.getNext();
			}
			
			removed = removeNode(prevNode, node);
		}
		
		return removed;
	}

	private boolean removeNode(Node<T> prevNode, Node<T> node) {
		boolean removed = false;
		if (null != node)
		{
			if (null != prevNode)
			{
				prevNode.setNext(node.getNext());
			}
			
			if (head.equals(node))
			{
				head = null;
			}
			
			if (tail.equals(node))
			{
				tail = null;
			}
			
			removed = true;
		}
		return removed;
	}
	
	public T findMiddle()
	{
		T value = null;
		if (!isEmpty())
		{
			
			Node<T> curNode = head;
			Node<T> midNode = head;
			
			
			while (!curNode.equals(tail))
			{
				curNode = curNode.getNext();
				
				if (!curNode.equals(tail))
				{
					curNode = curNode.getNext();
					midNode = midNode.getNext();
				}
			}
			
			value = midNode.getValue();
		}
		
		return value;
	}
	
	public void addAll(T[] values)
	{
		for (T t : values) {
			add(t);
		}
	}
	
	public void reversed()
	{
		if (!isEmpty() && !head.equals(tail))
		{
			Node<T> curNode = head;
			
			reversed(head);
			
			Node<T> newTail = head;
			
			head = tail;
			tail = newTail;
			tail.setNext(null);
		}
	}

	private void reversed(Node<T> curNode)
	{
		
		Node<T> next = curNode.getNext();
		
		if (!tail.equals(next))
		{
			reversed(next);
		}
		next.setNext(curNode);
	}
}
