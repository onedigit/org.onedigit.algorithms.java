package org.onedigit.algorithms.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

import org.onedigit.algorithms.graph.Node.Colour;

/**
 * Adjacency list representation of a Graph.
 * The edges can be either weighted or non-weighted.
 * If they are non-weighted, we assign a default weight of 0.
 * 
 * <p> Reference: Introduction to Algorithms, CLRS, 3rd Edition
 * 
 * @author ahmed
 * 
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

    /**
     * Get the adjacency list ({@link List}) of the given node
     * @param source node for which we require the adjacency
     * @return {@link List} of {@link Edge}
     */
    public List<Edge<E>> getAdjacency(Node<E> source)
    {
        return adjacencies.get(source);
    }

    /**
     * Get all the edges of the graph
     * @return {@link List} of all the edges ({@link Edge})
     */
    public List<Edge<E>> getAllEdges()
    {
        List<Edge<E>> edges = new ArrayList<>();
        for (List<Edge<E>> e : adjacencies.values()) {
            edges.addAll(e);
        }
        return edges;
    }

    /**
     * Get all the nodes contained in the given edge list
     * @param edges {@link List} of {@link Edge}
     * @return {@link Set} of {@link Node}
     */
    public Set<Node<E>> getNodes(List<Edge<E>> edges)
    {
        Set<Node<E>> nodes = new TreeSet<>();
        for (Edge<E> e : edges) {
            nodes.add(e.getSource());
            nodes.add(e.getTarget());
        }
        return nodes;
    }

    /**
     * Get all the nodes of the graph
     * @return {@link Set} of {@link Node}
     */
    public Set<Node<E>> getAllNodes()
    {
        return getNodes(getAllEdges());
    }

    @Override
    public String toString()
    {
        return dotFormat();
    }

    /**
     * Test whether source is connected to target by any
     * path in the graph.  We use a depth first search to
     * do this.
     * @param source source node
     * @param target target node
     * @return
     */
    public boolean isConnected(Node<E> source, Node<E> target)
    {
        // Colour everything white before start
        Set<Node<E>> allNodes = getAllNodes();
        for (Node<E> n : allNodes) {
            n.setColour(Colour.WHITE);
        }
        boolean result = false;
        Stack<Node<E>> stack = new Stack<>();
        stack.push(source);
        while (!stack.empty()) {
            Node<E> u = stack.pop();
            if (u.equals(target)) {
                result = true;
                break;
            }
            if (u.getColour() == Colour.WHITE) {
                u.setColour(Colour.GRAY);
                List<Edge<E>> edges = getAdjacency(u);
                if (edges != null) {
                    Set<Node<E>> nodes = getNodes(edges);
                    for (Node<E> node: nodes) {
                        if (node.getColour() == Colour.WHITE) {
                            stack.push(node);
                        }
                    }
                } 
            }
        }
        return result;
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
}
