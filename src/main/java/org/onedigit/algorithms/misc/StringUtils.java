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
	
	public static void main(String[] args)
	{
		System.out.println(reverse("Another day in paradise"));
		String s = reverseWords("Another day in paradise", ' ');
		System.out.println(s);
	}
}
