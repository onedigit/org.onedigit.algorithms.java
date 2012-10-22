package org.onedigit.algorithms.lru;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class LRUCacheTest
{

    @Test
    public void test()
    {
        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        
        cache.put(1, 10);
        cache.put(2, 20);
        cache.put(3, 30);
        cache.put(4, 40);
        cache.put(5, 50);
        cache.put(6, 60);
        cache.put(7, 70);
        
        Assert.assertEquals(5, cache.size());
    }
}
