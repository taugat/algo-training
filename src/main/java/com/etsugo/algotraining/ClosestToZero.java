package com.etsugo.algotraining;

import java.util.stream.IntStream;

public class ClosestToZero
{
	public static void main(String[] args)
	{
		System.out.println(
			closestToZero(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE + 1})
			);
	}
	
	static int closestToZero(int[] ints)
	{
		if (null == ints)
		{
			return 0;
		}
		
		return IntStream.of(ints)
			.reduce(ClosestToZero::closestToZero)
			.orElse(0);
	}

	private static int closestToZero(int integer1, int integer2)
	{
		int compare = Integer.compare(Math.abs(integer1), Math.abs(integer2));
		if (compare > 0)
		{
			return integer2;
		}
		else if (compare < 0)
		{
			return integer1;
		}
		else if (integer1 > 0)
		{
			return integer1;
		}
		else
		{
			return integer2;
		}
	}
}
