package org.onedigit.algorithms.graph;

import java.io.Serializable;

public class Node<E extends Comparable<? super E>> implements
        Comparable<Node<E>>, Serializable
{
	private static final long serialVersionUID = 1L;

	public enum Colour {
		WHITE, GRAY, BLACK
	}

	private E value;
	private Colour colour = null;
	private int distance = 0; // used in shortest path algorithms
	private Node<E> parent = null; // used in shortest path algorithms

	public static <E extends Comparable<? super E>> Node<E> makeNode(E value)
	{
		return new Node<E>(value);
	}
	
	public Node(E value)
	{
		this.value = value;
	}

	@Override
	public boolean equals(Object other)
	{
		boolean result = false;
		if (other instanceof Node) {
			Node<?> that = (Node<?>) other;
			result = that.value == this.value;
		}
		return result;
	}

	@Override
	public int hashCode()
	{
		return value.hashCode();
	}

	@Override
	public int compareTo(Node<E> other)
	{
		return (value.compareTo(other.getValue()));
	    // return (distance - other.distance);
	}

	@Override
	public String toString()
	{
		return String.valueOf(value);
	}

	public void setColour(Colour colour)
	{
		this.colour = colour;
	}

	public Colour getColour()
	{
		return colour;
	}

	public E getValue()
	{
		return value;
	}

	public int getDistance()
    {
    	return distance;
    }

	public void setDistance(int distance)
    {
    	this.distance = distance;
    }

	public Node<E> getParent()
    {
    	return parent;
    }

	public void setParent(Node<E> parent)
    {
    	this.parent = parent;
    }
}
