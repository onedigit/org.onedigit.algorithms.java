package org.onedigit.algorithms.graph;

import static org.junit.Assert.*;

import org.junit.Test;
import org.onedigit.algorithms.graph.Graph;
import org.onedigit.algorithms.graph.Node;

public class GraphTest
{
    @Test
    public void test()
    {
        System.out.println("Running test");
        
        Graph<Integer> graph = new Graph<>();
        
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        
        System.out.println("Adding edge a->b");
        graph.addEdge(a,  b);
        System.out.println("Adding edge a->c");
        graph.addEdge(a,  c);
        System.out.println("Getting all edges");
        graph.getAllEdges();
    }
}
