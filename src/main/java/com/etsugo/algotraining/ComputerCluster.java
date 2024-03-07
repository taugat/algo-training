package com.etsugo.algotraining;

import java.util.Iterator;
import java.util.List;

public class ComputerCluster
{
	public static void main(String[] args)
	{
		System.out.println(calcMaxCluster(List.of(4,1,5,5,5,5,1,5, 1, 1 ,1), 6, 2));
	}

	private static int calcMaxCluster(List<Integer> computerSpeeds, int minSpeed, int minSize)
	{
		Iterator<Integer> iterator = computerSpeeds.iterator();
		
		int maxCluster = 0;
		
		while (iterator.hasNext())
		{
			int curSum = 0;
			int i = 0;
			for(;i < minSize && iterator.hasNext();i++)
			{
				curSum += iterator.next();
			}
			
			while (curSum < minSpeed && iterator.hasNext())
			{
				curSum += iterator.next();
			}
			
			
			if (!(!iterator.hasNext() && (i < minSize || curSum < minSpeed)))
			{
				maxCluster += 1; 
			}
		}
		
		return maxCluster;
	}
}
