package org.onedigit.algorithms.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * An LRU cache implemented with LinkedHashMap
 * 
 * @author ahmed
 *
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V>
{
    private static final long serialVersionUID = -5058735247287160697L;
    
    private int maxEntries;
    
    public LRUCache(int maxEntries)
    {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
    {
        return size() > maxEntries;
    }
}
