package org.onedigit.algorithms.graph;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.Test;

public class DijkstraTest
{
	@Test
	public void test()
	{
        Graph<Integer> graph = new Graph<>();
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        graph.addEdge(one, two, 7);
        graph.addEdge(one, three, 9);
        graph.addEdge(one, six, 14);
        graph.addEdge(two, three, 10);
        graph.addEdge(two, four, 15);
        graph.addEdge(three, four, 11);
        graph.addEdge(three, six, 2);
        graph.addEdge(six, five, 9);
        graph.addEdge(four, five, 6);
        System.out.println(graph);		
        Dijkstra<Integer> dst = new Dijkstra<>();
        dst.solve(graph, one);      
        dst.print();
	}
	
	public void testPriority()
	{
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		pQ.add(10);
		pQ.add(50);
		pQ.add(30);
		while (pQ.peek() != null) {
			Integer i = pQ.remove();
			System.out.println(i);
		}
	}
}
