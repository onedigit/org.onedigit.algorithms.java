package org.onedigit.algorithms.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class DisjointSet<E>
{
	private ArrayList<ArrayList<E>> set = new ArrayList<ArrayList<E>>();

	public void createSubsets(E[] items)
	{
		createSubsets(Arrays.asList(items));
	}

	public void createSubsets(Collection<E> items)
	{
		for (E item : items) {
			ArrayList<E> subset = new ArrayList<E>();
			subset.add(item);
			set.add(subset);
		}
	}

	public void merge(int setA, int setB)
	{
		set.get(setA).addAll(set.get(setB));
		set.remove(setB);
	}

	public int find(E searchfor)
	{
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i).contains(searchfor)) {
				return i;
			}
		}
		return -1;
	}
}
