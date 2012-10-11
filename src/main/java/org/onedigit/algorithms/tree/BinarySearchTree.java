package org.onedigit.algorithms.tree;

/**
 * Binary search tree.
 * Reference: Introduction to Algorithms, CLRS, 3rd Edition
 *  
 * @author ahmed
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>>
{
    private Node<T> root;
    
    // ------------------------------------------------------------------------
    
    public BinarySearchTree()
    {
    }
    
    // ------------------------------------------------------------------------
    
    public void add(T key)
    {
        
    }
    
    // ------------------------------------------------------------------------    
    
    public void insert(T key)
    {
        Node<T> y = null;
        Node<T> x = root;
        while (x != null) {
            y = x;
            if (key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        Node<T> node = new Node<T>(key);
        node.pred = y;
        if (y == null) {
            root = node; // Tree was empty
        } else if (node.key.compareTo(y.key) < 0){
            y.left = node;
        } else {
            y.right = node;
        }
    }
    
    // ------------------------------------------------------------------------
    
    public void remove(Node<T> node)
    {
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        }
    }
    
    // ------------------------------------------------------------------------
    
    /**
     * Transplant replaces one subtree as a child of its parent
     * with another subtree.  when transplant replaces the subtree
     * rooted at node u with the subtree rooted at node v, node
     * u's parent becomes node v's parent, and u's parent ends up
     * having v as its appropriate child.
     * 
     * Reference: CLRS, 3rd Edition
     * 
     * @param u
     * @param v
     */
    private void transplant(Node<T> u, Node<T> v)
    {
        if (u.pred == null) { // u is root
            root = v;
        } else if (u.equals(u.pred.left)) {
            u.pred.left = v;
        } else {
            u.pred.right = v;
        }
        if (v != null) {
            v.pred = u.pred;
        }
    }
    
    // ------------------------------------------------------------------------
    
    /**
     * Recursive search down the tree. Running time is O(h) where h is the
     * height of the tree.
     * 
     * @param x
     * @param key
     * @return
     */
    public Node<T> search_r(Node<T> x, T key)
    {
        if (x == null || x.key.equals(key)) {
            return x;
        } 
        if (key.compareTo(x.key) < 0) {
            return search_r(x.left, key);
        } else {
            return search_r(x.right, key);
        }
    }
    
    // ------------------------------------------------------------------------
    
    public String inOrderTreeWalk()
    {
        StringBuilder sb = new StringBuilder();
        inOrderTreeWalk(root, sb);
        return sb.toString();
    }
    
    private void inOrderTreeWalk(Node<T> node, StringBuilder sb)
    {
        if (node != null) {
            inOrderTreeWalk(node.left, sb);
            sb.append(node.key);
            sb.append(" ");
            inOrderTreeWalk(node.right, sb);
        }
    }    
    
    // ------------------------------------------------------------------------
    
    public String preOrderTreeWalk()
    {
        StringBuilder sb = new StringBuilder();
        preOrderTreeWalk(root, sb);
        return sb.toString();
    }
    
    private void preOrderTreeWalk(Node<T> node, StringBuilder sb)
    {
        if (node != null) {
            sb.append(node.key);
            sb.append(" ");
            preOrderTreeWalk(node.left, sb);
            preOrderTreeWalk(node.right, sb);
        }
    }

    // ------------------------------------------------------------------------
    
    public String postOrderTreeWalk()
    {
        StringBuilder sb = new StringBuilder();
        postOrderTreeWalk(root, sb);
        return sb.toString();
    }

    private void postOrderTreeWalk(Node<T> node, StringBuilder sb)
    {
        if (node != null) {
            postOrderTreeWalk(node.left, sb);
            postOrderTreeWalk(node.right, sb);
            sb.append(node.key);
            sb.append(" ");
        }
    }
    
    // ------------------------------------------------------------------------    
}
