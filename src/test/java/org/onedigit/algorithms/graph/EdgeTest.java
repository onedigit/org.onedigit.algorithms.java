package org.onedigit.algorithms.graph;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class EdgeTest
{
	@Test
	public void test()
	{
		Node<Integer> a = new Node<Integer>(1);
		Node<Integer> b = new Node<Integer>(2);
		Edge<Integer> edgeA = new Edge<>(a, b, 10);
		int hashA = edgeA.hashCode();
		
		Edge<Integer> edgeB = new Edge<>(a, b, 10);
		int hashB = edgeB.hashCode();
		
		Assert.assertEquals(hashA, hashB);
		
		boolean eq = edgeA.equals(edgeB);
		Assert.assertEquals(true, eq);
	}
}
