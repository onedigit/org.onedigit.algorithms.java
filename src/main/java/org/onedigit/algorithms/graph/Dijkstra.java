package org.onedigit.algorithms.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

	public Set<Node<E>> solve(Graph<E> graph, Node<E> start)
	{
		initialise(graph, start);
		Set<Node<E>> vertices = graph.getAllNodes();
		pQ.addAll(vertices);
		Set<Node<E>> nodes = new HashSet<>();
		while (!pQ.isEmpty()) {
			Node<E> u = pQ.remove();
			nodes.add(u);
			List<Edge<E>> edges = graph.getAdjacency(u);
			System.out.println("Adj of " + u + " = " + edges);
			if (edges != null) {
				for (Edge<E> edge : edges) {
					Node<E> v = edge.getTarget();
					// System.out.println("\t" + v);
					relax(u, v, edge.getWeight());
				}
			}
		}
		return nodes;
	}
	
	private void relax(Node<E> u, Node<E> v, int weight)
	{
		int vd = v.getDistance();
		int ud = u.getDistance();
		if (vd > ud + weight) {
			v.setDistance(ud + weight);
			v.setParent(u);
		}
	}

	public void print()
	{
		while (!pQ.isEmpty()) {
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
