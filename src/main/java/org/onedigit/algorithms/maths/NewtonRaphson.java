package org.onedigit.algorithms.maths;

/**
 * Newton's method for calculating the square root.
 * 
 * @author ahmed
 *
 */
public class NewtonRaphson
{
	private static final double TOLERANCE = 1.0E-6;
	private static final int MAX_ITERATIONS = 100;
	
	/**
	 * Evaluate f(x) = x^2 - a
	 * @param x
	 * @return
	 */
	public double f(double x, double a)
	{
	    return (x * x - a);
	}
	
	/**
	 * Derivative of f(x) = x^2 - a
	 * @param x
	 * @return
	 */
	public double fdash(double x)
	{
		return (2.0 * x);
	}
	
	public double eval(double x0, double a)
	{
	    double x1 = 0.0;
		int iteration = 0;
		double f0 = f(x0, a);
		while (Math.abs(f0) > TOLERANCE && iteration < MAX_ITERATIONS) {
            x1 = x0 - f0 / fdash(x0);
			x0 = x1;
			f0 = f(x0, a);
			iteration++;
		}
		System.out.println("Root = " + x1 + " iterations = " + iteration);
		return x1;
	}
	
	public static void main(String... args)
	{
		NewtonRaphson nr = new NewtonRaphson();
		double a = 2.0;
		double result = nr.eval(1.0, a);
		System.out.println(Math.sqrt(a) - result);
	}
}
