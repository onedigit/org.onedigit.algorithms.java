package org.onedigit.algorithms.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest
{
    @Test
    public void test()
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

        System.out.print("InOrder: ");
        bst.inOrderTreeWalk();
        System.out.println();
        
        System.out.print("PreOrder: ");
        bst.preOrderTreeWalk();
        System.out.println();
        
        System.out.print("PostOrder: ");
        bst.postOrderTreeWalk();
        System.out.println();
    }
}
