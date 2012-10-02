package org.onedigit.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Map<Node<E>, List<Edge<E>>> adjacencyList;
    
    public Graph()
    {
        adjacencyList = new HashMap<>();
    }
    
    public void addEdge(Node<E> source, Node<E> destination)
    {
        List<Edge<E>> edges = adjacencyList.get(source);
        if (edges == null) {
            edges = new ArrayList<>();
            adjacencyList.put(source, edges);
        } 
        edges.add(new Edge<>(source, destination));
    }
    
    // TODO
    @Override
    public String toString()
    {
        return "";
    }
}
