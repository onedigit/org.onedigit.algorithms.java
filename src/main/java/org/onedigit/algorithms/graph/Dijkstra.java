package org.onedigit.algorithms.graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra<E extends Comparable<? super E>> implements
        Iterable<Node<E>>
{
	private PriorityQueue<Node<E>> pQ;

	public Dijkstra()
	{
		pQ = new PriorityQueue<Node<E>>(1, new Comparator<Node<E>>() {
			@Override
			public int compare(Node<E> o1, Node<E> o2)
			{
				return o1.getDistance() - o2.getDistance();
			}
		});
	}

	public void initialise(Graph<E> graph, Node<E> start)
	{
		Set<Node<E>> vertices = graph.getAllNodes();
		for (Node<E> v : vertices) {
			v.setDistance(Integer.MAX_VALUE);
			v.setParent(null);
		}
		start.setDistance(0);
	}

	public void solve(Graph<E> graph, Node<E> start)
	{
		initialise(graph, start);
		Set<Node<E>> vertices = graph.getAllNodes();
		pQ.addAll(vertices);
	}

	public void print()
	{
		while (pQ.peek() != null) {
			Node<E> n = pQ.remove();
			System.out.println(n);
		}		
	}

	@Override
	public Iterator<Node<E>> iterator()
	{
		return pQ.iterator();
	}
}
