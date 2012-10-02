package org.onedigit.algorithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Adjaceny list representation of a Graph
 * 
 * @author ahmed
 *
 * @param <E>
 */
public class Graph<E>
{
    private Map<Node<E>, List<Node<E>>> adjacencyList;
    
    public void addEdge(Edge<E> edge)
    {
        List<Node<E>> list = adjacencyList.get(edge.begin());
        if (list == null) {
            list = new ArrayList<>();
            list.add(edge.end());
        } else {
            
        }
    }
}
