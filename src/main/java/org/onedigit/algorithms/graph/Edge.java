package org.onedigit.algorithms.graph;


/**
 * Representation of an edge linking two nodes ({@link Node})
 * in a {@link Graph}.
 * 
 * @author ahmed
 * 
 */
public class Edge<E extends Comparable<? super E>> implements Comparable<Edge<E>>
{
    private Node<E> source;
    private Node<E> target;
    private int weight;

    /**
     * Default constructor assigns a weight of 0 to the edge
     * @param source
     * @param target
     */
    public Edge(Node<E> source, Node<E> target)
    {
        this.source = source;
        this.target = target;
        this.weight = 0;
    }

    public Edge(Node<E> source, Node<E> target, int weight)
    {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object other)
    {
        boolean result = false;
        if (other instanceof Edge) {
            Edge<?> that = (Edge<?>) other;
            result = 
            		that.source == this.source && 
            		that.target == this.target &&
            		that.weight == this.weight;
        }
        return result;
    }
    
    @Override
    public int hashCode()
    {
    	int hash = 1;
    	hash = hash * 41 + source.hashCode();
    	hash = hash * 41 + target.hashCode();
    	hash = hash * 41 + weight;
    	return hash;
    }

	@Override
    public int compareTo(Edge<E> other)
    {
		return source.getValue().compareTo(target.getValue());
    }
	
    Node<E> getSource()
    {
        return source;
    }

    Node<E> getTarget()
    {
        return target;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(source);
        sb.append("--");
        sb.append(target);
        return sb.toString();
    }
    
    public void setWeight(int weight) { this.weight = weight; }
    
    public int getWeight() { return weight; }
}
