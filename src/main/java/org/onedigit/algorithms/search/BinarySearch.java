package org.onedigit.algorithms.search;

import java.util.Arrays;

/**
 * An implementation of binary search in both recursive
 * and iterative form.
 * 
 * @author ahmed
 *
 */
public class BinarySearch
{
    /**
     * Do a recursive binary search on the given array for the
     * given value 
     * @param a
     * @param value
     * @param start  start index
     * @param stop end index
     * @return -1 if the value cannot be found, otherwise
     * the index of the value in the array
     */
    public static int search_r(int a[], int value, int start, int stop)
    {
        if (start > stop)
            return -1;
        // find mid point
        int mid = start + ((stop - start) >>> 1);
        if (value == a[mid]) {
            return mid;
        }
        if (value < a[mid]) {
            return search_r(a, value, start, mid = 1);
        } else {
            return search_r(a, value, mid + 1, stop);
        }
    }

    /**
     * Do an iterative binary search on the given array for the
     * given value
     * @param a
     * @param value
     * @return -1 if the value cannot be found, otherwise
     * the index of value in the array
     */
    public static int search_i(int a[], int value)
    {
        int result = -1;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
        	int mid = start + ((end - start) >>> 1);
            int tmp = a[mid];
            if (tmp == value) {
                result = mid;
                break;
            } else if (value < tmp) {
                end = mid - 1;
            } else if (value > tmp) {
                start = mid + 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args)
    {
        int a[] = {2, 3, 10, 20, 50, 100};
        int ret = search_r(a, 50, 0, a.length - 1);
        System.out.println(ret);
        ret = search_i(a, 100);
        System.out.println(ret);
        ret = Arrays.binarySearch(a, 50);
        System.out.println(ret);
    }
}
