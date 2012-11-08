package org.onedigit.algorithms.tree;

import java.util.Stack;

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
        node.parent = y;
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
        if (u.parent == null) { // u is root
            root = v;
        } else if (u.equals(u.parent.left)) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        if (v != null) {
            v.parent = u.parent;
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
    
	/**
	 * Iterative search
	 */
    public Node<T> search(T key)
    {
    	return search(root, key);
    }
    
    public Node<T> search(Node<T> node, T key)
    {
    	Node<T> x = node;
    	while (x != null && key != x.key) {
    		if (key.compareTo(x.key) < 0) {
    			x = x.left;
    		} else {
    			x = x.right;
    		}
    	}
    	return x;
    }
    
    // ------------------------------------------------------------------------
    
    public void inOrderTreeWalk(NodeVisitor<T> visitor)
    {
        inOrderTreeWalk(root, visitor);
    }
    
    private void inOrderTreeWalk(Node<T> node, NodeVisitor<T> visitor)
    {
        if (node != null) {
            inOrderTreeWalk(node.left, visitor);
            visitor.visit(node);
            inOrderTreeWalk(node.right, visitor);
        }
    }    
    
    // TODO
    public void inOrderTreeWalkIterative(NodeVisitor<T> visitor)
    {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        boolean done = false;
        while (!done) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (!stack.isEmpty()) {
                    node = stack.pop();
                    visitor.visit(node);
                    node = node.right;
                } else {
                    done = true;
                }
            }
        }
    }
    
    // ------------------------------------------------------------------------
    
    public void preOrderTreeWalk(NodeVisitor<T> visitor)
    {
        preOrderTreeWalk(root, visitor);
    }
    
    private void preOrderTreeWalk(Node<T> node, NodeVisitor<T> visitor)
    {
        if (node != null) {
            visitor.visit(node);
            preOrderTreeWalk(node.left, visitor);
            preOrderTreeWalk(node.right, visitor);
        }
    }
    
    public void preOrderTreeWalkIterative(NodeVisitor<T> nodeVisitor)
    {
        Node<T> node = root;
        if (node != null) {
            Stack<Node<T>> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                nodeVisitor.visit(node); // visit node
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    // ------------------------------------------------------------------------
    
    public void postOrderTreeWalk(NodeVisitor<T> visitor)
    {
        postOrderTreeWalk(root, visitor);
    }

    private void postOrderTreeWalk(Node<T> node, NodeVisitor<T> visitor)
    {
        if (node != null) {
            postOrderTreeWalk(node.left, visitor);
            postOrderTreeWalk(node.right, visitor);
            visitor.visit(node);
        }
    }
    
    // TODO
    public void postOrderTreeWalkIterative(NodeVisitor<T> visitor)
    {
        
    }
    
    // ------------------------------------------------------------------------    
}
