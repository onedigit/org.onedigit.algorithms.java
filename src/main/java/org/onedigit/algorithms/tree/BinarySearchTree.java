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
    
    public BinarySearchTree()
    {
    }
    
    public void add(T key)
    {
        
    }
    
    public void insert(Node<T> node)
    {
        Node<T> pred = null;
        Node<T> x = root;
        while (x != null) {
            pred = x;
            if (node.key.compareTo(x.key) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.pred = pred;
        if (pred == null) {
            root = node; // Tree was empty
        } else if (node.key.compareTo(pred.key) < 0){
            pred.left = node;
        } else {
            pred.right = node;
        }
    }
    
    public void remove(T key)
    {
        
    }
    
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
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Node<Integer> six = new Node<Integer>(6); 
        Node<Integer> five_1 = new Node<Integer>(5); 
        Node<Integer> eleven = new Node<Integer>(11); 
        Node<Integer> twelve = new Node<Integer>(12); 
        Node<Integer> seven = new Node<Integer>(7); 
        Node<Integer> eight = new Node<Integer>(8); 
        Node<Integer> nine = new Node<Integer>(9); 
        Node<Integer> two = new Node<Integer>(2); 
        Node<Integer> five_2 = new Node<Integer>(5);


        bst.insert(six);
        bst.insert(five_1);
        bst.insert(eleven);
        bst.insert(twelve);
        bst.insert(nine);
        bst.insert(two);
        bst.insert(five_2);

        System.out.print("InOrder: " + bst.inOrderTreeWalk());
        System.out.println();
        
        System.out.print("PreOrder: " + bst.preOrderTreeWalk());
        System.out.println();
        
        System.out.print("PostOrder: " + bst.postOrderTreeWalk());
        System.out.println();
    }
}
