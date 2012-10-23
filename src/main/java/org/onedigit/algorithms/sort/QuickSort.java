package org.onedigit.algorithms.sort;

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
            int middle = partition(arr, left, right);
            qsort(arr, left, middle - 1);
            qsort(arr, middle + 1, right);
        }
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
		Random rand = new Random(0);
		int R_MAX = 10_000_000;
		int MAX = 1_000_000;
		int[] b = new int[MAX];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < MAX; j++) {
				b[j] = rand.nextInt(R_MAX);
			}
			TimerUtility.start();
			sort(b);
			// Arrays.sort(b);
			double elapsed = TimerUtility.end();
			System.out.println("Elapsed = " + elapsed);
		}
	}
}
