package org.onedigit.algorithms.tree;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class BinarySearchTreeTest
{
    @Test
    public void test()
    {
        final StringBuilder sb = new StringBuilder();
        NodeVisitor<Integer> nodeVisitor = new NodeVisitor<Integer>() {
            @Override
            public void visit(Node<Integer> node)
            {
                sb.append(node);
                sb.append(" ");
            }
        };
        
    	BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        makeTree(bst, 11, 2, 14, 1, 7, 15, 5, 8, 4);

        sb.setLength(0);
        bst.inOrderTreeWalk(nodeVisitor);
        System.out.println("InOrder: \t\t" + sb.toString());
        
        sb.setLength(0);
        bst.inOrderTreeWalkIterative(nodeVisitor);
        System.out.println("InOrder Iterative: \t" + sb.toString());
        
        sb.setLength(0);
        bst.preOrderTreeWalk(nodeVisitor);
        System.out.println("PreOrder: \t\t" + sb.toString());

        sb.setLength(0);
        bst.preOrderTreeWalkIterative(nodeVisitor);
        System.out.println("PreOrder Iterative: \t" + sb.toString());
        
        sb.setLength(0);
        bst.postOrderTreeWalk(nodeVisitor);
        System.out.println("PostOrder: \t\t" + sb.toString());
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
