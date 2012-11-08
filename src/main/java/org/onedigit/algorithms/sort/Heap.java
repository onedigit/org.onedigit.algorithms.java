package org.onedigit.algorithms.sort;


/**
 * This is a max heap
 * 
 * @author ahmed
 *
 * @param <E>
 */
public class Heap<E extends Comparable<? super E>>
{
	private E[] arr;
	private int lastIndex = 0;
	
	@SuppressWarnings("unchecked")
    public Heap(int size)
	{
	    arr = (E[])new Comparable[size];
	}
	
	public int parent(int i)
	{
		return i >>> 1;
	}
	
	public int left(int i)
	{
		return i << 1;
	}
	
	public int right(int i)
	{
		return (i << 1) + 1;
	}
	
	public void insert(E item)
	{
	    int currentPos = lastIndex;
	    int parentPos = parent(currentPos - 1);
	    while (currentPos != 0) {
	        if (item.compareTo(arr[parentPos]) > 0) {
	            arr[currentPos] = arr[parentPos];
                currentPos = parentPos;
                parentPos = parent(currentPos - 1);
	        } else { // heap condition is satisfied
	            break;
	        }
	    }
	    arr[currentPos] = item;
	    lastIndex++;
	}
	
	@Override
	public String toString()
	{
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < lastIndex; i++) {
	        sb.append(arr[i] + " ");
	    }
	    return sb.toString();
	}
	
	public static void main(String... args)
	{
		Heap<Integer> heap = new Heap<>(11);
		heap.insert(63);
		heap.insert(30);
		heap.insert(40);
		heap.insert(10);
		heap.insert(25);
		heap.insert(8);
		heap.insert(38);
		heap.insert(5);
		heap.insert(3);
		heap.insert(18);
		heap.insert(50);
		System.out.println(heap);
	}
}
