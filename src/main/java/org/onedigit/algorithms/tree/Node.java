package org.onedigit.algorithms.tree;


public final class Node<T extends Comparable<? super T>> 
	implements Comparable<Node<T>>
{
	public enum Colour { RED, BLACK }
	
    T key;
    Node<T> right;
    Node<T> left;
    Node<T> parent;
    Colour colour;
    
    public Node(T key)
    {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    
	@Override
    public String toString()
    {
        return key.toString();
    }
	
	@Override
    public int compareTo(Node<T> other)
    {
		return (this.key.compareTo(other.key));
    }	
	
	@Override
	public boolean equals(Object other)
	{
		boolean result = false;
		if (other instanceof Node) {
			Node<?> that = (Node<?>) other;
			result = that.key == this.key;
		}
		return result;
	}

	@Override
	public int hashCode()
	{
		return key.hashCode();
	}
	
	public T getKey()
    {
    	return key;
    }

	public void setKey(T key)
    {
    	this.key = key;
    }

	public Node<T> getRight()
    {
    	return right;
    }

	public void setRight(Node<T> right)
    {
    	this.right = right;
    }

	public Node<T> getLeft()
    {
    	return left;
    }

	public void setLeft(Node<T> left)
    {
    	this.left = left;
    }

	public Node<T> getParent()
    {
    	return parent;
    }

	public void setParent(Node<T> parent)
    {
    	this.parent = parent;
    }

	public Colour getColour()
    {
    	return colour;
    }

	public void setColour(Colour colour)
    {
    	this.colour = colour;
    }
}





