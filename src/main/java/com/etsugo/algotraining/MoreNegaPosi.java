package com.etsugo.algotraining;

import java.util.Arrays;

public class MoreNegaPosi
{
	public static void main(String[] args)
	{
		System.out.println(test(new int[]
			{-12,-4 ,-45,-43,-4 ,-341,-474
			,0    
			,54 ,54 ,542,121,21 ,212 }));
	}

	private static boolean test(int[] is)
	{
		
		Arrays.sort(is);
		
		int midIndex = is.length/2;
		int val = is[midIndex];
		if (val == 0)
		{
			int val1 = 0; int val2 = 0;
			int index = midIndex / 2;
			int start = 0;
			int end = midIndex;
			
			val1 = is[index];
			val2 = is[is.length - 1 - index];
			
			boolean finish = false;
			while (!finish)
			{
				if (index == 0 && val1 == 0)
				{
					break;
				}
				
				if (val1 == 0)
				{
					end = index;
				}
				else
				{
					start = index;
				}
				index = (end - start) / 2 + start;
				val1 = is[index];
				val2 = is[is.length - 1 - index];
				boolean zero = val1 == 0 && val2 != 0;
				boolean notZero = val1 != 0 && val2 == 0;
				
				if (zero && index > 0)
				{
					zero = is[index - 1] != 0;
				}
				else if (notZero && index < midIndex)
				{
					notZero = is[index + 1] == 0;
				}
				finish = !zero && !notZero;
			}
			return val1 == 0;
		}
		else
		{
			return val > 0;
		}
	}
}
