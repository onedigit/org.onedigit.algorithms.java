package org.onedigit.algorithms.generic;

import java.util.Arrays;

/**
 * 
 * @author ahmed
 *
 */
public class BinarySearch
{
    /**
     * Do a binary search on the given array for the
     * given value 
     * @param a
     * @param value
     * @param start  start index
     * @param stop end index
     * @return -1 if the value cannot be found, otherwise
     * the index of the value in the array
     */
    public static int search(int a[], int value, int start, int stop)
    {
        if (start > stop)
            return -1;
        
        // find mid point
        int mid = (start + stop) / 2;
        if (value == a[mid]) {
            return mid;
        }
        
        if (value < a[mid]) {
            return search(a, value, start, mid = 1);
        } else {
            return search(a, value, mid + 1, stop);
        }
    }

    /**
     * Do a binary search on the given array for the
     * given value
     * @param a
     * @param value
     * @return -1 if the value cannot be found, otherwise
     * the index of value in the array
     */
    public static int search(int a[], int value)
    {
        int result = -1;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
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
        int ret = search(a, 50, 0, a.length - 1);
        System.out.println(ret);
        ret = search(a, 100);
        System.out.println(ret);
        ret = Arrays.binarySearch(a, 50);
        System.out.println(ret);
    }
}
