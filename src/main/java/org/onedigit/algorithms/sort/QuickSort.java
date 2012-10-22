package org.onedigit.algorithms.sort;

import java.util.Arrays;

public class QuickSort
{
	static void qsort(int[] arr, int begin, int end)
	{
		System.out.println("Input arr: " + Arrays.toString(arr));
		// get the pivot, i.e. middle element
		int pivot = (end - begin) >>> 1;
		System.out.println("pivot = " + pivot);
		swap(arr, begin, pivot);
		System.out.println("After swapping pivot: " + Arrays.toString(arr));
		
		// arrange left and right halves on either side of pivot
		int p = begin + 1;
		int q = end - 1;
		while (p < q) {
			if (arr[p] <= arr[pivot]) {
				p++;
			} else {
				swap(arr, p, q);
				q--;
			}
		}
		// put pivot in the right place
		System.out.println("q = " + q);
		swap(arr, begin, q);
	}
	
	/**
	 * Swap elements at indices i and j
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args)
	{
		int[] a = {70, 50, 20, 80, 5, 25, 90};
		qsort(a, 0, a.length);
		System.out.println("After qsort: " + Arrays.toString(a));
	}
}
