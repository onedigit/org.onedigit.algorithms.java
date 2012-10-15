package org.onedigit.algorithms.misc;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class StringUtilsTest
{

	@Test
	public void testReverse()
	{
		String s = StringUtils.reverse("Another day in paradise");
		String expected = "esidarap ni yad rehtonA";
		Assert.assertEquals(expected, s);
	}

	@Test
	public void testReverseWords()
	{
		String s = StringUtils.reverseWords("Another day in paradise", ' ');
		String expected = "rehtonA yad ni esidarap";
		Assert.assertEquals(expected, s);		
	}
}
