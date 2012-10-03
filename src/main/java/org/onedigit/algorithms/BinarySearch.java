package org.onedigit.algorithms;

/**
 * 
 * @author ahmed
 *
 */
public class BinarySearch
{
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
    
    
    public static void main(String[] args)
    {
        int a[] = {20, 50, 100, 3, 2, 10};
        int ret = search(a, 50, 0, a.length - 1);
        System.out.println(ret);
    }
}
