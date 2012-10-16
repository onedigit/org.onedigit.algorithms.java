package org.onedigit.algorithms.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpanningTree<E extends Comparable<? super E>> implements Serializable
{
    private static final long serialVersionUID = 1L;

	/**
	 * Kruskal's algorithm for minimum spanning tree.
	 * 
	 * @param nodes
	 * @param edges
	 * @return
	 */
	public List<Edge<E>> getMinimumSpannningTree(List<Edge<E>> edges)
	{
		List<Node<E>> nodes = new ArrayList<Node<E>>();
		for (Edge<E> e : edges) {
			nodes.add(e.getSource());
			nodes.add(e.getTarget());
		}
		Collections.sort(edges);
		ArrayList<Edge<E>> spanningTree = new ArrayList<Edge<E>>();
		DisjointSet<Node<E>> nodeset = new DisjointSet<Node<E>>();
		nodeset.createSubsets(nodes);
		for(Edge<E> e : edges){
			if(nodeset.find(e.getSource()) != nodeset.find(e.getTarget())){
				nodeset.merge(nodeset.find(e.getSource()), nodeset.find(e.getTarget()));
				spanningTree.add(e);
			}
		}
		return spanningTree;
	}
	
}
