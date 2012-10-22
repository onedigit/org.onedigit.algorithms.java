package org.onedigit.algorithms.sort;

import java.util.Arrays;

import org.onedigit.algorithms.tree.Node;

public class Heap<E extends Comparable<? super E>>
{
	Node<E> root;
	
	public int parent(int i)
	{
		return i >>> 1;
	}
	
	public int left(int i)
	{
		return i << 1;
	}
	
	public int right(int i)
	{
		return (i << 1) + 1;
	}
	
	public static void main(String... args)
	{
		System.out.println(Arrays.toString(args));
	}
}
