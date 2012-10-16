package org.onedigit.algorithms.sort;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * An implementation of merge sort (without sentinels).
 * Reference: Introduction to Algorithms, CLRS, 3rd Edition
 * 
 * @author ahmed
 *
 */
public class MergeSort
{			
	@SuppressWarnings("unchecked")
    public static void merge(Object[] a, int low, int mid, int high)
	{
		int lenL = mid - low + 1;
		Object[] L = new Object[lenL];
		int lenM = high - mid;
		Object[] M = new Object[lenM];
		System.arraycopy(a, low, L, 0, lenL);
		System.arraycopy(a, mid + 1, M, 0, lenM);
		System.out.println("low = " + low + ", mid = " + mid + ", high = " + high);
		System.out.println("L = " + Arrays.toString(L));
		System.out.println("M = " + Arrays.toString(M));
		int i = 0;
		int j = 0;
		for (int k = low; k <= high; k++) {
			if (j >= lenM || (i < lenL && ((Comparable<Object>)L[i]).compareTo(M[j]) < 0)) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = M[j];
				j++;
			}
		}
	}
	
	public static void merge_sort(Object[] a, int low, int high)
	{
		if (low < high) {
			int mid = (low + high) >>> 1;
			merge_sort(a, low, mid);
			merge_sort(a, mid + 1, high);
			merge(a, low, mid, high);
		}		
	}
	
	@SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void sort(List<T> list)
	{
		Object[] a = list.toArray(); 
		merge_sort(a, 0, a.length - 1);
        ListIterator<T> i = list.listIterator();
        for (int j = 0; j < a.length; j++) {
            i.next();
            i.set((T)a[j]);
        }
	}
	
	public static void main(String[] args)
	{
		List<Integer> list = Arrays.asList(50, 10);
		sort(list);
		System.out.println(list);
	}
}

