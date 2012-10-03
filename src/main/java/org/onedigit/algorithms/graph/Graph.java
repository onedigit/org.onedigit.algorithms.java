package org.onedigit.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Adjaceny list representation of a Graph
 * 
 * @author ahmed
 * 
 * @param <E>
 */
public class Graph<E>
{
    private Map<Node<E>, List<Edge<E>>> adjacencies;

    public Graph()
    {
        adjacencies = new HashMap<>();
    }

    public void addEdge(Node<E> source, Node<E> target)
    {
        List<Edge<E>> edges = adjacencies.get(source);
        if (edges == null) {
            edges = new ArrayList<>();
            adjacencies.put(source, edges);
        }
        boolean edgeContainsTarget = edgeContainsNode(edges, target);
        if (edgeContainsTarget == false) {
            edges.add(new Edge<>(source, target));
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
            nodes.add(e.source());
            nodes.add(e.target());
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
            Node<E> other = e.target();
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
    private String dotFormat()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {\n");
        Collection<Edge<E>> edges = getAllEdges();
        for (Edge<E> e : edges) {
            sb.append("\t\"" + e.source() + "\" -> \"" + e.target() + "\";\n");
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
            sb.append("\t" + e.source() + " -- " + e.target() + ";\n");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args)
    {
        Graph<Integer> graph = new Graph<>();

        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);

        graph.addEdge(a, b);
        graph.addEdge(a, c);
        System.out.println(graph);
    }
}
