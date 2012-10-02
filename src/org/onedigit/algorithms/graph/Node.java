package org.onedigit.algorithms.graph;

public class Node<E>
{
    E value;
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = false;
        if (other instanceof Node) {
            @SuppressWarnings("unchecked")
            Node<E> that = (Node<E>)other;
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
