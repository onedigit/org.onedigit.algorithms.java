package org.onedigit.algorithms.sort;

import java.util.Arrays;

public class QuickSort
{
    public static void sort(int[] arr)
    {
        qsort(arr, 0, arr.length - 1);
    }
    
    private static void qsort(int[] arr, int left, int right)
    {
        if (right <= left) { // single element, already sorted
            return;
        }
        int middle = partition(arr, left, right);
        qsort(arr, left, middle - 1);
        System.out.println("Doing right..., middle = " + middle + ", right = " + right 
                + " a = " + Arrays.toString(arr));
        qsort(arr, middle + 1, right);
    }
    
    private static int partition(int[] arr, int left, int right)
	{
	    // get the pivot, i.e. middle element
		int pivot = (right - left) >>> 1;
		System.out.print("Pivot pos = " + pivot + ", pivot = " + arr[pivot]);
		// arrange left and right halves on either side of pivot
		int p = left;
		int q = right;
		while (p <= q) {
		    while (arr[p] < arr[pivot]) {
		        p++;
		    }
		    while (arr[q] > arr[pivot]) {
		        q--;
		    }
		    if (p <= q) {
		        swap(arr, p, q);
		        p++;
		        q--;
		    }
		}
		System.out.println(", After partition: " + Arrays.toString(arr));
		return p;  // final position of pivot
	}
	
	private static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args)
	{
		int[] a = {70, 50, 20, 80, 5, 25, 90};
		System.out.println("Input arr: " + Arrays.toString(a));
		sort(a);
		System.out.println("After qsort: " + Arrays.toString(a));
	}
}
