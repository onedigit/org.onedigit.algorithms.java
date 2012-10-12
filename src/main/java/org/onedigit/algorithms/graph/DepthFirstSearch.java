package org.onedigit.algorithms.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Depth first traversal implementation.
 *  
 * @author Ahmed Riza
 *
 */
public class DepthFirstSearch<T extends Comparable<? super T>> implements Serializable
{
    private static final long serialVersionUID = 1L;
	private Node<T> nodeFound = null;
	
	/**
	 * Do a depth first traversal and return the list of nodes
	 * in post-order.
	 * 
	 * @return
	 */
	public List<Node<T>> dfs(Graph<T> graph, Set<Node<T>> nodes)
	{
		Node<T> start = nodes.iterator().next();
		List<Node<T>> postOrder = new ArrayList<Node<T>>();
		doDfs(graph, postOrder, start);
		postOrder.add(start);
		return postOrder;
	}

	public List<Node<T>> dfs(Graph<T> graph, Node<T> start)
	{
		List<Node<T>> postOrder = new ArrayList<Node<T>>();
		doDfs(graph, postOrder, start);
		postOrder.add(start);
		return postOrder;
	}
	
	private void doDfs(Graph<T> graph, List<Node<T>> postOrder, Node<T> u)
	{
		u.setColour(Node.Colour.GRAY);
		List<Edge<T>> adj = graph.getAdjacency(u);
		if (adj != null) {
			Set<Node<T>> nodes = graph.getNodes(adj);
			for (Node<T> v : nodes) {
				if (v.getColour() == null) {
					doDfs(graph, postOrder, v);
					if (postOrder != null) {
						postOrder.add(v);
					}
				}
			}
		}
	}
	
	public Node<T> dfsSearch(Graph<T> graph, Set<Node<T>> nodes, String searchName)
	{
		if (nodes.iterator().hasNext()) {
			Node<T> start = nodes.iterator().next();
			return doDfsSearch(graph, start, searchName);
		} else {
			return null;
		}
		
	}
	
	public Node<T> dfsSearch(Graph<T> graph, Node<T> start, String searchName)
	{
		return doDfsSearch(graph, start, searchName);
	}
	
	public Node<T> dfsSearch(Graph<T> graph, String searchName)
	{
		return doDfsSearch(graph, searchName);
	}
	
	private Node<T> doDfsSearch_r(Graph<T> graph, Node<T> u, String searchName)
	{
		if (nodeFound == null) {
			u.setColour(Node.Colour.GRAY);
			List<Edge<T>> adj = graph.getAdjacency(u);
			if (adj != null) {
				Set<Node<T>> nodes = graph.getNodes(adj);
				for (Node<T> v : nodes) {
					if (v.value().equals(searchName)) {
						v.setColour(Node.Colour.WHITE);
						nodeFound = v;
					} else if (v.getColour() == null) {
						doDfsSearch(graph, v, searchName);
					}
				}
			}
		}
		return nodeFound;
	}	
	
	public Node<T> doDfsSearch(Graph<T> graph, Node<T> u, String searchName)
	{
		Stack<Node<T>> stack = new Stack<Node<T>>();
		stack.push(u);
		u.setColour(Node.Colour.GRAY);
		Node<T> found = null;
		while(!stack.isEmpty()) {
			Node<T> t = stack.pop();
			if(t.value().equals(searchName)) {
				found = t;
				break;
			}
			List<Edge<T>> adj = graph.getAdjacency(t);
			if (adj != null) {
				Set<Node<T>> nodes = graph.getNodes(adj);
				for (Node<T> n : nodes) {
					if (n.getColour() == null) {
						n.setColour(Node.Colour.GRAY);
						stack.push(n);
					}
				}
			}
		}
		return found;
	}
	
	public Node<T> doDfsSearch(Graph<T> graph, String searchName)
	{
		Set<Node<T>> allNodes = graph.getAllNodes();
		for (Node<T> u : allNodes) {
			u.setColour(Node.Colour.WHITE);
		}
		Stack<Node<T>> stack = new Stack<Node<T>>();
		Node<T> found = null;
		for (Node<T> u : allNodes) {
			if (u.getColour().equals(Node.Colour.WHITE) && found == null) {
				u.setColour(Node.Colour.GRAY);
				stack.push(u);
				while (!stack.isEmpty()) {
					Node<T> t = stack.pop();
					if (t.value().equals(searchName)) {
						found = t;
						break;
					}
					List<Edge<T>> adj = graph.getAdjacency(t);
					if (adj != null) {
						Set<Node<T>> nodes = graph.getNodes(adj);
						for (Node<T> n : nodes) {
							if (n.getColour() == null) {
								n.setColour(Node.Colour.GRAY);
								stack.push(n);
							}
						}
					}
				}
			}
		}
		return found;
	}
}
