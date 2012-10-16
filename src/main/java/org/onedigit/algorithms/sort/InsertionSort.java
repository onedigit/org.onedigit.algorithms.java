package org.onedigit.algorithms.sort;

/**
 * An implementation of insertion sort
 * Reference: Introduction to Algorithms, CLRS, 3rd Edition
 * 
 * Loop invariant:
 * <p>
 * At the start of the iteration of each for loop, the sub array
 * a[0...j-1] consists of the elements originally in a[0...j-1],
 * but in sorted order.
 * </p>
 * 
 * @author ahmed
 *
 */
public class InsertionSort
{
    public static <T extends Comparable<? super T>> void sort(T[] a)
    {
        int len = a.length;
        for (int j = 1; j < len; j++) {
            T key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i].compareTo(key) > 0) {
                a[i + 1] = a[i];
                i = i - 1;
            }
            a[i + 1] = key;
        }
    }
}
