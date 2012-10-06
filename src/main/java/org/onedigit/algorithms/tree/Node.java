package org.onedigit.algorithms.tree;

final class Node<T>
{
    T key;
    Node<T> right;
    Node<T> left;
    Node<T> pred;
    
    public Node(T key)
    {
        this.key = key;
        this.left = null;
        this.right = null;
        this.pred = null;
    }
    
    public void setPredecessor(Node<T> pred)
    {
        this.pred = pred;
    }
    
    @Override
    public String toString()
    {
        return key.toString();
    }
}





