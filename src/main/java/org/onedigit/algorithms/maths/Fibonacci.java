package org.onedigit.algorithms.maths;

/**
 * Use dynamic programming to evaluate Fibonacci numbers.
 * 
 * @author ahmed
 *
 */
public class Fibonacci
{
    // 92 is the maximum we can fit in a long
    public static final int MAX = 93;  
    
    public static long eval(int i)
    {
        long[] fib = new long[MAX];
        
        fib[0] = 0;
        fib[1] = 1;
        
        for (int j = 2; j <= i; j++) {
            fib[j] = fib[j - 1] + fib[j - 2];
            System.out.println("fib[" + j + "] = " + fib[j]);
        }
        
        return fib[i];
    }
    
    public static void main(String[] args)
    {
        long ret = eval(92);
        System.out.println(ret);
    }
}
