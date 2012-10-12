package org.onedigit.algorithms.cache.perf;

import java.util.concurrent.Semaphore;

public class Cmp extends Thread
{
	Semaphore sem;
	int va[];
	int TOTAL_ACCESS;
	int s1 = 0;
	
	public Cmp(int[] arr, int acc, Semaphore s)
	{
		va = arr;
		TOTAL_ACCESS = acc;
		sem = s;
	}
	
	public void run()
	{
		try {
			sem.acquire();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		int STRIDE = 16;
		int NUM_WAYS = 1;
		for (int j = 0; j < TOTAL_ACCESS; j += NUM_WAYS * STRIDE) {
			s1 = va[s1];
			s1 = va[s1];
			s1 = va[s1];
			s1 = va[s1];
			s1 = va[s1];
			s1 = va[s1];
			s1 = va[s1];
			s1 = va[s1];
		}
		sem.release();
	}
}
