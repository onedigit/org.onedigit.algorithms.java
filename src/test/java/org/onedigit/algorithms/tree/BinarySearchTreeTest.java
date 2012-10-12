package org.onedigit.algorithms.tree;

import static org.junit.Assert.*;
import junit.framework.Assert;

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
        
        byte b = -128;
        short s = 32767;
        System.out.println(Math.pow(2, 16));
    }
    
    @Test
    public void searchTest()
    {
    	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        makeTree(bst, 11, 2, 14, 1, 7, 15, 5, 8, 4);
        Node<Integer> node = bst.search(7);
        Assert.assertNotNull(node);
        Assert.assertEquals(new Integer(7), node.key);
    }
    
    public <T extends Comparable<? super T>> void makeTree(BinarySearchTree<T> tree,
    		T... args)
    {
    	for (T t : args) {
    		tree.insert(t);
    	}
    }
}
