package org.onedigit.algorithms.sort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest
{

    @Test
    public void test()
    {
        Integer[] a = {31, 41, 59, 26, 41, 58};
        Integer[] expected = {26, 31, 41, 41, 58, 59};
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
        Assert.assertTrue(Arrays.equals(expected, a));
    }

}
