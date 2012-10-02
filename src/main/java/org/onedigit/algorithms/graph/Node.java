package org.onedigit.algorithms.graph;

public class Node<E>
{
    public enum Colour {
        WHITE, GRAY, BLACK
    }
    
    E value;
    
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
}
