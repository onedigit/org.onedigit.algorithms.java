package org.onedigit.algorithms.maths;

public class NewtonRaphson
{
	double tolerance = 1.0E-6;
	
	/**
	 * Sqrt(x)
	 * @param x
	 * @return
	 */
	public double f(double x)
	{
		return Math.sqrt(x);
	}
	
	/**
	 * Derivative of Sqrt(x)
	 * @param x
	 * @return
	 */
	public double fdash(double x)
	{
		return (1.0 / (2.0 * Math.sqrt(x)));
	}
	
	public void eval(double x0)
	{
		double x1 = x0 - f(x0) / fdash(x0);
		double diff = Math.abs(x1 - x0);
		while (diff > tolerance) {
			x1 = x0 - f(x0) / fdash(x0);
			diff = Math.abs(x1 - x0);
		}
		System.out.println("Root = " + x1);
	}
	
	public static void main(String... args)
	{
		NewtonRaphson nr = new NewtonRaphson();
		nr.eval(1.0);
	}
}
