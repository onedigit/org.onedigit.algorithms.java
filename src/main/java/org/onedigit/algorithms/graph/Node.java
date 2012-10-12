package org.onedigit.algorithms.graph;

import java.io.Serializable;


public class Node<E extends Comparable<? super E>> implements Comparable<Node<E>>, Serializable
{
    private static final long serialVersionUID = 1L;

	public enum Colour {
        WHITE, GRAY, BLACK
    }
    
    private E value;
	private Colour colour = null;
	
    public Node(E value)
    {
        this.value = value;
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = false;
        if (other instanceof Node) {
            Node<?> that = (Node<?>)other;
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
		return (value.compareTo(other.value()));
    }
	
    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
    
	public void setColour(Colour colour) { this.colour = colour; }
	
	public Colour getColour() {	return colour; }   
	
	public E value() { return value; }
}
