package org.onedigit.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;
import org.onedigit.algorithms.graph.Graph;
import org.onedigit.algorithms.graph.Node;

public class GraphTest
{
    @Test
    public void test()
    {
        Graph<Integer> graph = new Graph<>();
        
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        
        graph.addEdge(a,  b);
        graph.addEdge(a,  c);
    }
}
