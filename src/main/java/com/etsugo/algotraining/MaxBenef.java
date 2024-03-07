package com.etsugo.algotraining;

import java.util.List;

public class MaxBenef
{
	public static void main(String[] args)
	{
		System.out.println(calcMaxBenef(List.of(5, 20, 0, 1)));
	}

	private static int calcMaxBenef(List<Integer> stockPrices)
	{
		int min = stockPrices.getFirst();
		int max = min;
		int currentMax = -1;
		
		for (Integer price : stockPrices)
		{
			if (price < min)
			{
				min = price;
			}
			else if (price > max)
			{
				max = price;
				currentMax = max - min;
			}
		}
		return currentMax;
	}
}
