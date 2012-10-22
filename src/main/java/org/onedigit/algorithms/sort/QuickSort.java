package org.onedigit.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.onedigit.algorithms.misc.TimerUtility;

public class QuickSort
{
    public static void sort(int[] arr)
    {
        qsort(arr, 0, arr.length - 1);
    }
    
    private static void qsort(int[] arr, int left, int right)
    {
    	if (left < right) {
    		int middle = partition_old(arr, left, right);
    		if (middle < left) {
    			System.out.println("middle = " + middle + ", left = " + left);
    			qsort(arr, middle + 1, left);
    		}
    		if (middle > left) {
    			System.out.println("middle = " + middle + ", left = " + left);
    			qsort(arr, left, middle - 1);
    		}
    	}
    }
    
    /**
     * Parition using the middle element
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int partition_old(int[] arr, int left, int right)
	{
	    // get the pivot, i.e. middle element
    	int middle = left + (right - left) / 2;
		int pivot = arr[middle];
		
		System.out.println("pivot = " + pivot);
		
		// Get the pivot out of the way and put on the left
    	swap(arr, left, middle);
    	
		// arrange left and right halves on either side of pivot
		int p = left + 1;
		int q = right;
		
		while (p <= q) {
			while (p < right && arr[p] < pivot) {
		        p++;
		    }
		    while (q > left && arr[q] > pivot) {
		        q--;
		    }
		    if (p <= q) {
		        swap(arr, p, q);
		        p++;
		        q--;
		    }
		}
		// restore pivot
		swap(arr, left, q);
		System.out.println("\toutput: " + Arrays.toString(arr));
		System.out.println();
		return p;  // final position of pivot
	}
    
    /**
     * Partition algorithm from Introduction to Algorithms, CLRS, 3rd Edition
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] arr, int p, int r)
    {
    	int pivot = arr[r];
    	int i = p - 1;
    	for (int j = p; j < r; j++) {
    		if (arr[j] <= pivot) {
    			i++;
    			swap(arr, i, j); // exchange A[i], A[j]
    		}
    	}
    	swap(arr, i+1, r); // exchange A[i+1] with A[r]
    	return i+1;
    }
	
	private static void swap(int[] arr, int i, int j)
	{
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args)
	{
		// int[] a = {70, 50, 20, 80, 5, 25, 90};
		// System.out.println("Input arr: " + Arrays.toString(a));
		// sort(a);
		// System.out.println("After qsort: " + Arrays.toString(a));
		
		Random rand = new Random(0);
		int R_MAX = 10_000_000;
		int MAX = 5;
		int[] b = new int[MAX];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < MAX; j++) {
				b[j] = rand.nextInt(R_MAX);
			}
			
			int[] c = new int[MAX];
			System.arraycopy(b, 0, c, 0, b.length);
			
			TimerUtility.start();
			sort(b);
			// Arrays.sort(b);
			double elapsed = TimerUtility.end();
			System.out.println("Elapsed = " + elapsed);
			System.out.println(Arrays.toString(b));
			
			Arrays.sort(c);
			System.out.println(Arrays.toString(c));			
		}
	}
}
