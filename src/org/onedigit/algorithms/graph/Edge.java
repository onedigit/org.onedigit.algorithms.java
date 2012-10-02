package org.onedigit.algorithms.graph;

public class Edge<E>
{
    Node<E> begin;
    Node<E> end;
    
    public Edge(Node<E> begin, Node<E> end)
    {
        this.begin = begin;
        this.end = end;
    }
    
    Node<E> begin() { return begin; }
    
    Node<E> end() { return end; }
}
