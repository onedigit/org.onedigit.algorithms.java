package org.onedigit.algorithms.graph;

import java.util.List;

import org.junit.Test;

public class DijkstraTest
{
	@Test
	public void testShortestPath()
	{
		// This is the graph shown in the Wikipedia article:
		// http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm

		Graph<Integer> graph = new Graph<>();
		
		Node<Integer> one = Node.makeNode(1);
		Node<Integer> two = Node.makeNode(2);
		Node<Integer> three = Node.makeNode(3);
		Node<Integer> four = Node.makeNode(4);
		Node<Integer> five = Node.makeNode(5);
		Node<Integer> six = Node.makeNode(6);

		graph.addEdge(one, two, 7);
		graph.addEdge(one, three, 9);
		graph.addEdge(one, six, 14);
		graph.addEdge(two, three, 10);
		graph.addEdge(two, four, 15);
		graph.addEdge(three, four, 11);
		graph.addEdge(three, six, 2);
		graph.addEdge(four, five, 6);
		graph.addEdge(six, five, 9);

		shortestPath(graph, one, six);
	}

	@Test 
	public void testAnotherShortestPath()
	{
		// This is the graph in Figure 24.2 of CLRS
		
		Graph<String> graph = new Graph<>();

		Node<String> s = Node.makeNode("s");
		Node<String> t = Node.makeNode("t");
		Node<String> x = Node.makeNode("x");
		Node<String> y = Node.makeNode("y");
		Node<String> z = Node.makeNode("z");

		graph.addEdge(s, t, 3);
		graph.addEdge(s, y, 5);
		graph.addEdge(t, x, 6);
		graph.addEdge(t, y, 5);
		graph.addEdge(x, z, 2);
		graph.addEdge(z, x, 7);
		graph.addEdge(z, s, 3);
		graph.addEdge(y, z, 6);
		graph.addEdge(y, x, 4);
		graph.addEdge(y, t, 1);
		
		shortestPath(graph, s, x);
	}

	private <E extends Comparable<? super E>> void shortestPath(Graph<E> graph,
	        Node<E> u, Node<E> v)
	{
		Dijkstra<E> dst = new Dijkstra<>();
		List<Node<E>> path = dst.getShortestPath(graph, u, v);
		System.out.println(path);
	}
}
