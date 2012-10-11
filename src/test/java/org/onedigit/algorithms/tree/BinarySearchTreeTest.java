package org.onedigit.algorithms.tree;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest
{
    @Test
    public void test()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        makeTree(bst, 11, 2, 14, 1, 7, 15, 5, 8, 4);

        System.out.print("InOrder: " + bst.inOrderTreeWalk());
        System.out.println();
        
        System.out.print("PreOrder: " + bst.preOrderTreeWalk());
        System.out.println();
        
        System.out.print("PostOrder: " + bst.postOrderTreeWalk());
        System.out.println();
    }
    
    public <T extends Comparable<? super T>> void makeTree(BinarySearchTree<T> tree,
    		T... args)
    {
    	for (T t : args) {
    		tree.insert(t);
    	}
    }
}