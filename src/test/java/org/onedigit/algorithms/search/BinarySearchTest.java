package org.onedigit.algorithms.search;

import static org.junit.Assert.*;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;
import org.onedigit.algorithms.search.BinarySearch;

public class BinarySearchTest
{

    @Test
    public void test()
    {
        int a[] = {2, 3, 10, 20, 50, 100};
        int ret = BinarySearch.search_r(a, 50, 0, a.length - 1);
        Assert.assertEquals(4, ret);
        
        ret = BinarySearch.search_i(a, 100);
        Assert.assertEquals(5, ret);
    }
}
