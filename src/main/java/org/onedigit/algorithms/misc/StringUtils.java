package org.onedigit.algorithms.misc;

public class StringUtils
{
	public static String reverse(String s)
	{
		char[] buf = s.toCharArray();
		int end = s.length() - 1;
		for (int i = 0; i < s.length() / 2; i++) {
			char c = buf[end];
			buf[end] = buf[i];
			buf[i] = c;
			end--;
		}
		String str = new String(buf);
		return str;
	}
	
	public static String reverseWords(String s, char sep)
	{
		StringBuilder result = new StringBuilder(s.length());
		char[] buf = s.toCharArray();
		int end = s.length();
		int i = 0;
		while (i < end) {
			int start = i; 
			int last = start;
			while (i < end && buf[i] != sep) {
				i++;
				last++;
			} 
			i++;
			int length = last - start;
			char[] tmp = new char[length];
			System.arraycopy(buf, start, tmp, 0, length);
			result.append(reverse(new String(tmp)));
			if (i < end) {
				result.append(sep);
			}
		}
		return result.toString();
	}
	
	public static void swap(char[] a, int i, int j)
	{
		char c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
	
	public static void permute_rr(String prefix, String rest)
	{
		if (rest.length() == 0) {
			System.out.println(prefix);
		}
		for (int i = 0; i < rest.length(); i++) {
			String newPrefix = prefix + String.valueOf(rest.charAt(i));
			String newRest = rest.substring(0, i) + rest.substring(i + 1); 
			permute_rr(newPrefix, newRest);
		}
	}
	
	public static void permute_r(char[] a, int n)
	{
		if (n == 1) {
			System.out.println(a);
			return;
		} 
		for (int i = 0; i < n; i++) {
			swap(a, i, n-1);
			permute_r(a, n-1);
			swap(a, i, n-1);
		}
	}
		
	public static void permute(String s)
	{
		int len = s.length();
		//
		// abc, acb, bac, bca, cab, cba
		// abc, acb, bac, bca, cab, cba
		// abc, acb
		// bac, bca
		// cab, cba
		// 
		// abcde
		// a -> perm(bcde) 
		//   b -> perm(cde)
		//     c -> perm(de)
		//       d -> perm(e)
		//
		char[] buf = s.toCharArray();
		permute_r(buf, s.length());
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		permute_rr("", "abc");
		System.out.println(reverse("Another day in paradise"));
		String s = reverseWords("Another day in paradise", ' ');
		System.out.println(s);
	}
}
