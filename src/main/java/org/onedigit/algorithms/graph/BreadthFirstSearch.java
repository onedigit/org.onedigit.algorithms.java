package org.onedigit.algorithms.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Breadth first traversal implementation.
 * 
 */
public class BreadthFirstSearch<T extends Comparable<? super T>> implements Serializable
{
    private static final long serialVersionUID = 1L;

	/**
	 * Do a breadth first traversal and return the list of nodes
	 * in post-order.
	 * 
	 */
	public List<Node<T>> bfs(Graph<T> graph, Set<Node<T>> nodes)
	{
		Node<T> start = nodes.iterator().next();
		List<Node<T>> postOrder = new ArrayList<Node<T>>();
		doBfs(graph, postOrder, start);
		return postOrder;
	}
	
	private void doBfs(Graph<T> graph, LinkedList<Node<T>> fifo, List<Node<T>> postOrder, Node<T> u)
	{
		u.setColour(Node.Colour.GRAY);
		List<Edge<T>> adj = graph.getAdjacency(u);
		if (adj != null) {
			Set<Node<T>> nodes = graph.getNodes(adj);
			for (Node<T> n : nodes) {
				if (n.getColour() == null) {
					fifo.add(n);
				}
			}
		}
		if (!fifo.isEmpty()) {
			Node<T> first = fifo.removeFirst();
			doBfs(graph, fifo, postOrder, first);
		}
		postOrder.add(u);
	}
	
	private void doBfs(Graph<T> graph, List<Node<T>> postOrder, Node<T> u)
	{
		LinkedList<Node<T>> fifo = new LinkedList<Node<T>>();
		fifo.add(u);
		postOrder.add(u);
		u.setColour(Node.Colour.GRAY);
		while (!fifo.isEmpty()) {
			Node<T> t = fifo.removeFirst();
			List<Edge<T>> adj = graph.getAdjacency(t);
			if (adj != null) {
				Set<Node<T>> nodes = graph.getNodes(adj);
				for (Node<T> n : nodes) {
					if (n.getColour() == null) {
						postOrder.add(n);
						n.setColour(Node.Colour.GRAY);
						fifo.add(n);
					}
				}
			}
		}
		Collections.reverse(postOrder);
	}	
}
