package org.onedigit.algorithms.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * An implementation of Dijkstra's algorithm for all pairs shortest paths.
 * Reference: Introduction to Algorithms, CLRS, 3rd Edition.
 * 
 * @author ahmed
 *
 * @param <E>
 */
public class Dijkstra<E extends Comparable<? super E>>
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
		Set<Node<E>> V = graph.getAllNodes();
		pQ.addAll(V);
		Set<Node<E>> S = new HashSet<>();
		// Loop maintains the invariant: v.distance = 
		// d(u, v) where d = minimum distance
		// pQ contains V - S elements, where V = all
		// nodes of the graph and S contains the nodes
		// so far processed. 
		while (!pQ.isEmpty()) {
			Node<E> u = pQ.remove();
			S.add(u);
			List<Edge<E>> edges = graph.getAdjacency(u);
			if (edges != null) {
				for (Edge<E> edge : edges) {
					Node<E> v = edge.getTarget();
					relax(u, v, edge.getWeight());
					// re-prioritise the node v
					pQ.remove(v);
					pQ.add(v);
				}
			}
		}
		return S;
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
}
