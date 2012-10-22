package org.onedigit.algorithms.sort;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest
{

    @Test
    public void test()
    {
        int[] a = {70, 50, 20, 80, 5, 25, 90};
        System.out.println("Input arr: " + Arrays.toString(a));
        QuickSort.sort(a);
        System.out.println("After qsort: " + Arrays.toString(a));
        int[] expected = {5, 20, 25, 50, 70, 80, 90}; 
    }

}
