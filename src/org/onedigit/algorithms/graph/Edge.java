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
    Node<E> destination;

    public Edge(Node<E> source, Node<E> destination)
    {
        this.source = source;
        this.destination = destination;
    }

    Node<E> source()
    {
        return source;
    }

    Node<E> destination()
    {
        return destination;
    }
}
