package com.etsugo.algotraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MinProccTime
{
	public static void main(String[] args)
	{
		System.out.println(calcMinProcTime(2, new ArrayList<Integer>(List.of(8, 10)), new ArrayList<Integer>(List.of(2,2,3,1,8,7,4,5))));
	}

	private static int calcMinProcTime(int nbProcessor, List<Integer> processorTime, List<Integer> tasks)
	{
		Collections.sort(processorTime, Comparator.reverseOrder());
		Collections.sort(tasks);
		
		Iterator<Integer> iterator = tasks.iterator();
		Iterator<Integer> processorTimeIterator = processorTime.iterator();
		int max = -1;
		
		for (int i = 0; i < tasks.size(); i += 4)
		{
			iterator.next();iterator.next();iterator.next();
			Integer integer = iterator.next();
			max = Integer.max(max, integer + processorTimeIterator.next());
		}
		
		
		return max;
	}
}
