package org.onedigit.algorithms.tree.rb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.onedigit.algorithms.tree.Node;

public class RedBlackTreeTest
{
    public static String ACROBAT;
    public static String NEATO;
    public static String DOT;

    @BeforeClass
    public static void before()
    {
        String os = System.getProperty("os.name");
        System.out.println("Running tests on " + os);
        if (os.contains("Windows")) {
            ACROBAT = "C:\\Program Files\\Adobe\\Reader 9.0\\Reader\\AcroRd32.exe";
            NEATO = "C:\\Apps\\Graphviz 2.28\\bin\\neato.exe";
            DOT = "C:\\Apps\\Graphviz 2.28\\bin\\dot.exe";
        } else if (os.equals("Mac OS X")) {
            ACROBAT = "/usr/local/bin/AdobeReader";
            NEATO = "/usr/local/graphviz-2.14/bin/neato";
            DOT = "/usr/local/graphviz-2.14/bin/dot";
        }
    }
    
	@Test
	public void test() throws IOException
	{
		RedBlackTree<Integer> tree = new RedBlackTree<>();
		makeTree(tree, 15, 6, 7, 3, 4, 2, 13, 9, 17, 18, 20);
		String dotFormat = tree.dotFormat();
		System.out.println(dotFormat);
		renderDot(tree);
	}
	
	@Test
	public void testSearch() 
	{
		RedBlackTree<Integer> tree = new RedBlackTree<>();
		makeTree(tree, 15, 6, 7, 3, 4, 2, 13, 9, 17, 18, 20);
		
		Node<Integer> root = tree.search(15);
		Assert.assertNotNull(root);
		Assert.assertEquals(new Integer(15), root.getKey());
		
		Node<Integer> nodeExists = tree.search(13);
		Assert.assertNotNull(nodeExists);
		Assert.assertEquals(new Integer(13), nodeExists.getKey());
		
		Node<Integer> nodeDoesNotExist = tree.search(100);
		Assert.assertNull(nodeDoesNotExist);
	}
	
	@Test
	public void testLowestCommonAncestor()
	{
		RedBlackTree<Integer> tree = new RedBlackTree<>();
		makeTree(tree, 15, 6, 7, 3, 4, 2, 13, 9, 17, 18, 20);
		
		Node<Integer> lca = tree.findLowestCommonAncestor(15, 18);
		Assert.assertNotNull(lca);
		System.out.println("LCA (15, 18) = " + lca);
		
		Node<Integer> lca_2 = tree.findLowestCommonAncestor(9, 20);
		Assert.assertNotNull(lca_2);
		System.out.println("LCA (9, 20) = " + lca_2);
		
		Node<Integer> lca_3 = tree.findLowestCommonAncestor(2, 6);
		Assert.assertNotNull(lca_3);
		System.out.println("LCA (2, 6) = " + lca_3);
	}
	
	@Test
	public void capacityTest()
	{
		int numElements = 16;
        int initialCapacity = 8;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;
            System.out.println("initialCapacity = " + initialCapacity);
            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }		
	}
	
	private <E extends Comparable<? super E>> void makeTree(
			RedBlackTree<E> tree, E... args)
	{
		for (E arg : args) {
			tree.insert(arg);
		}
	}

	private <E extends Comparable<? super E>> void renderDot(RedBlackTree<E> tree)
            throws IOException
    {
        String filename = "graph.dot";
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                new File(filename)));
        bw.write(tree.dotFormat());
        bw.close();
        String neatoCmd = DOT + " -Tpdf " + filename + " -o graph.pdf";
        Runtime.getRuntime().exec(neatoCmd);
        // Runtime.getRuntime().exec(ACROBAT + " graph.pdf");
    }	
}
