package org.onedigit.algorithms.list;


public class SinglyLinkedList<E>
{
	private class Node
	{
		E value;
		Node next;
		
		public Node(E value)
		{
			this.value = value;
		}
		
		@Override
		public String toString()
		{
			return value.toString();
		}
	}
	
	private Node head = null;
	private Node tail = null;
	
	public void add(E value)
	{
		if (head == null) {
			head = tail = new Node(value);
		} else {
			tail = tail.next = new Node(value);
		}
	}
	
	public void remove__(E value)
	{
		if (head == null) {
			return;
		}
		Node prev = null;
		Node current = head;
		Node next = current.next;
		while (current != null) {
			if (current.value.equals(value)) {
				current.next = null;
				if (prev != null) { // in case we are at head
					prev.next = next;
				}
				if (current == head) {
					head = next;
				}
				if (current == tail) {
					tail = next;
				}
				break;
			}
			prev = current;
			current = next;
			next = current.next;
		}
	}
	
	public void reverse()
	{
		Node current = head;
		Node prev = null;
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		Node tmp = head;
		head = tail;
		tail = tmp;
	}
	
	public void remove(E value)
	{
	    if (head == null) {
	        return;
	    }
	    Node prev = null;
	    Node current = head;
	    Node next = current.next;
	    while (current != null) {
	        if (current.value.equals(value)) {
	            current.next = null;
	            if (prev != null) {
	                prev.next = next;
	            }
	            if (current == head) {
	                head = next;
	            }
	            if (current == tail) {
	                tail = prev;
	            }
	            break;	            
	        }
	        prev = current;
	        current = next;
	        next = current.next;
	    }
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Node node = head;
		sb.append("[");
		while (node != null) {
			sb.append(node.value);
			if (node.next != null) {
				sb.append(", ");
			}
			node = node.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String... args)
	{
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.add(20);
		list.add(30);
		list.add(50);
		list.add(40);
		System.out.println(list);
		
		list.reverse();
		System.out.println(list);
		
		list.remove(20);
		list.remove(40);
		list.remove(30);
		list.remove(50);
		System.out.println(list);
		
		list.reverse();
		System.out.println(list);
	}
}
