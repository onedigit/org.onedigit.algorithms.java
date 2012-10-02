package org.onedigit.algorithms.graph;

/**
 * An edge of a graph
 * 
 * @author ahmed
 * 
 * @param <E>
 */
public class Edge<E>
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

    Node<E> source()
    {
        return source;
    }

    Node<E> target()
    {
        return target;
    }
}
