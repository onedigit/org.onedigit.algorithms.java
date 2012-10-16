package org.onedigit.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Adjaceny list representation of a Graph
 * 
 * @author ahmed
 * 
 * @param <E>
 */
public class Graph<E extends Comparable<? super E>>
{
    private Map<Node<E>, List<Edge<E>>> adjacencies;

    public Graph()
    {
        adjacencies = new HashMap<>();
    }

    /**
     * Add Edge with 0 weight
     * @param source
     * @param target
     */
    public void addEdge(Node<E> source, Node<E> target)
    {
    	addEdge(source, target, 0);
    }
    
    /**
     * Add Edge with the given weight
     * @param source
     * @param target
     * @param weight non-negative weight
     */
    public void addEdge(Node<E> source, Node<E> target, int weight)
    {
        List<Edge<E>> edges = adjacencies.get(source);
        if (edges == null) {
            edges = new ArrayList<>();
            adjacencies.put(source, edges);
        }
        boolean edgeContainsTarget = edgeContainsNode(edges, target);
        if (edgeContainsTarget == false) {
            edges.add(new Edge<>(source, target, weight));
        }
    }    

    public List<Edge<E>> getAdjacency(Node<E> source)
    {
        return adjacencies.get(source);
    }

    public List<Edge<E>> getAllEdges()
    {
        List<Edge<E>> edges = new ArrayList<>();
        for (List<Edge<E>> e : adjacencies.values()) {
            edges.addAll(e);
        }
        return edges;
    }

    public Set<Node<E>> getNodes(List<Edge<E>> edges)
    {
        Set<Node<E>> nodes = new TreeSet<>();
        for (Edge<E> e : edges) {
            nodes.add(e.getSource());
            nodes.add(e.getTarget());
        }
        return nodes;
    }

    public Set<Node<E>> getAllNodes()
    {
        return getNodes(getAllEdges());
    }

    @Override
    public String toString()
    {
        return dotFormat();
    }

    private boolean edgeContainsNode(List<Edge<E>> edges, Node<E> target)
    {
        boolean result = false;
        for (Edge<E> e : edges) {
            Node<E> other = e.getTarget();
            if (other.equals(target)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Graphviz dot format.
     * 
     * @return
     */
    public String dotFormat()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        Collection<Edge<E>> edges = getAllEdges();
        for (Edge<E> e : edges) {
            sb.append("\t\"" + e.getSource() + "\" -> \"" + e.getTarget() + "\";\n");
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * Graphviz neato format
     * 
     * @return
     */
    public String neatoFormat()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("graph G {\n");
        sb.append("{edge [len=3];\n");
        Collection<Edge<E>> edges = getAllEdges();
        for (Edge<E> e : edges) {
            sb.append("\t" + e.getSource() + " -- " + e.getTarget() + ";\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Graph<Integer> graph = new Graph<>();

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);

        graph.addEdge(one, two, 7);
        graph.addEdge(one, three, 9);
        graph.addEdge(one, six, 14);
        
        graph.addEdge(two, three, 10);
        graph.addEdge(two, four, 15);
        
        graph.addEdge(three, four, 11);
        graph.addEdge(three, six, 2);
        
        graph.addEdge(six, five, 9);
        
        graph.addEdge(four, five, 6);
        
        System.out.println(graph);
    }
}
