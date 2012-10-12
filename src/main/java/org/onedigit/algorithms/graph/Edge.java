package org.onedigit.algorithms.graph;

import java.io.Serializable;

/**
 * An edge of a graph
 * 
 * @author ahmed
 * 
 * @param <E>
 */
public class Edge<E extends Comparable<? super E>> implements Comparable<Edge<E>>, Serializable
{
    Node<E> source;
    Node<E> target;

    public Edge(Node<E> source, Node<E> target)
    {
        this.source = source;
        this.target = target;
    }

    @Override
    public boolean equals(Object other)
    {
        boolean result = false;
        if (other instanceof Edge) {
            Edge<?> that = (Edge<?>) other;
            result = that.source == this.source && that.target == this.target;
        }
        return result;
    }
    
    @Override
    public int hashCode()
    {
        return (41 * (41 + source.hashCode()) + target.hashCode());
    }

	@Override
    public int compareTo(Edge<E> other)
    {
		return source.value().compareTo(target.value());
    }
	
    Node<E> source()
    {
        return source;
    }

    Node<E> target()
    {
        return target;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(source);
        sb.append("--");
        sb.append(target);
        return sb.toString();
    }
}
