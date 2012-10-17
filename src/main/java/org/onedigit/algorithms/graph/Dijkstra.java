package org.onedigit.algorithms.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * An implementation of Dijkstra's algorithm (on a weighted directed graph)
 * for all pairs shortest paths.
 * Reference: Introduction to Algorithms, CLRS, 3rd Edition.
 * 
 * @author ahmed
 *
 * @param <E>
 */
public class Dijkstra<E extends Comparable<? super E>>
{
	private PriorityQueue<Node<E>> pQ; // min priority queue

	public Dijkstra()
	{
		pQ = new PriorityQueue<Node<E>>(16, new Comparator<Node<E>>() {
			@Override
			public int compare(Node<E> o1, Node<E> o2)
			{
				return o1.getDistance() - o2.getDistance();
			}
		});
	}

	/**
	 * Get the shortest path from u to v, in the given graph
	 * @param graph directed weighted graph
	 * @param u start node
	 * @param v end node
	 */
	public List<Node<E>> getShortestPath(Graph<E> graph, Node<E> u, Node<E> v)
	{
		Set<Node<E>> allPaths = solve(graph, u);
		List<Node<E>> path = new LinkedList<>();
		for (Node<E> node : allPaths) {
			if (node.equals(v)) {
				Node<E> end = node;
				while (end.getParent() != null) {
					path.add(0, end);
					end = end.getParent();
				}
				path.add(0, u);
				break;
			}
		}		
		return path;
	}
		
	/**
	 * Solve the all-pairs shortest path from the given start node
	 * @param graph Directed graph
	 * @param start start node
	 * @return the set S of nodes with their final path length
	 *         from the start node
	 */
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
					// Ensure we don't violate the loop invariant by 
					// inadvertently adding a node to the queue that has 
					// already been assigned the correct weight.
					if (relax(u, v, edge.getWeight())) {
						// 	re-prioritise the node v
						pQ.remove(v);
						pQ.add(v);
					}
				}
			}
		}
		return S;
	}
	
	private void initialise(Graph<E> graph, Node<E> start)
	{
		Set<Node<E>> vertices = graph.getAllNodes();
		for (Node<E> v : vertices) {
			v.setDistance(Integer.MAX_VALUE);
			v.setParent(null);
		}
		// Initialise the start node with the lowest priority
		start.setDistance(0); 
	}
	
	/**
	 * Relax the weights on the target node v
	 * @param u source node
	 * @param v target node
	 * @param weight edge weight from u to v
	 * @return true if v was updated
	 */
	private boolean relax(Node<E> u, Node<E> v, int weight)
	{
		boolean result = false;
		int vd = v.getDistance();
		int ud = u.getDistance();
		if (vd > ud + weight) {
			v.setDistance(ud + weight);
			v.setParent(u);
			result = true;
		}
		return result;
	}
}
