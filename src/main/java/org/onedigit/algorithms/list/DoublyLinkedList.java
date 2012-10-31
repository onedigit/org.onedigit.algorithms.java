package org.onedigit.algorithms.list;


public class DoublyLinkedList<E>
{
	private class Node
	{
		E value;
		Node prev;
		Node next;
		
		public Node(E value, Node prev, Node next)
		{
			this.value = value;
			this.prev = prev;
			this.next = next;
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
		Node tmp = tail;
		Node node = new Node(value, tail, null);
		tail = node;
		if (tmp == null) {
			head = node;
		} else {
			tmp.next = node;
		}
	}
	
	public void remove(E value)
	{
		if (head == null) {
			return;
		}
		Node current = head;
		while (current != null) {
			if (current.value.equals(value)) {
				Node prev = current.prev;
				// if prev != null, then we are not at head
				// must consider tail too
				if (prev != null) { 
					prev.next = current.next;
					// if we are not at tail
					if (current.next != null) { 
						current.next.prev = prev;
					}
				}
				if (current == head) {
					head = current.next;
					if (head != null) {
						head.prev = null;
					}
				}
				if (current == tail) {
					tail.next = null;
					tail = prev;
				}
				break;
			}
			current = current.next;
		}
	}
	
	public void reverse()
	{
		Node current = head;
		while (current != null) {
			Node prev = current.prev;
			Node next = current.next;
			current.prev = next;
			current.next = prev;
			current = next;
		}
		Node tmp = head;
		head = tail;
		tail = tmp;
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
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
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
		list.remove(20);
		System.out.println(list);
		list.reverse();
		System.out.println(list);		
	}
}
