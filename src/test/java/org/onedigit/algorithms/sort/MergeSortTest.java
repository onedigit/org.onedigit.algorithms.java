package org.onedigit.algorithms.sort;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MergeSortTest
{

	@Test
	public void test()
	{
		List<Integer> list = Arrays.asList(40, 10, 70, 130, 50);
		MergeSort.sort(list);
		List<Integer> expected = Arrays.asList(10, 40, 50, 70, 130);
		list.containsAll(expected);
	}
}
