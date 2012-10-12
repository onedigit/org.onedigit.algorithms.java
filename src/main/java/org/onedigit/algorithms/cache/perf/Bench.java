package org.onedigit.algorithms.cache.perf;

public class Bench
{
	public static void main(String[] argv)
	{
		String[] args = new String[7];
		args[0] = (new Integer(14)).toString();
		args[1] = argv[2]; // time
		args[2] = argv[0]; // stride
		args[3] = argv[1]; // ways
		args[4] = (new Integer(25)).toString();
		args[5] = "true";
		args[6] = "false";
		Tune.main(args);
	}
}
