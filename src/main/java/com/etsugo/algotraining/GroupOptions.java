package com.etsugo.algotraining;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GroupOptions
{
	public static void main(String[] args)
	{
		groupOptions(13,5).forEach(System.out::println);;
	}

	private static List<List<Integer>> groupOptions(int people, int groups)
	{
		List<List<Integer>> result = new ArrayList<>();
		
		int max = people / groups;
		int more = people % groups;
		
		ArrayList<Integer> firstGroup = Stream.generate(() -> max).limit(groups).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		
		result.add(firstGroup);
		
		if (more != 0)
		{
			for(int i = 1; i <= more; i++)
			{
				firstGroup.set(groups - i, firstGroup.get(groups - i) + 1);
			}
		}
		
		//the last index of element equals to 1;
		int currentLastOneIndex = max == 1 ? groups - 1 - more : -1;
		//the index available to be increment
		int availableDec = more > 1 ? groups - more : 0;
		int availableInc = groups - 1;
		
		ArrayList<Integer> currentGroup = firstGroup;
		
		while (currentLastOneIndex < groups - 2)
		{
			currentGroup = new ArrayList<>(currentGroup);

			int decValue = currentGroup.get(availableDec);
			decValue --;
			currentGroup.set(availableDec, decValue);
			currentGroup.set(availableInc, currentGroup.get(availableInc) + 1);
			
			result.add(currentGroup);
			
			if (1 == decValue)
			{
				currentLastOneIndex = availableDec;
			}
			availableDec ++;
			availableInc --;
			
			if (availableDec >= availableInc)
			{
				availableDec = currentLastOneIndex + 1;
				availableInc = groups - 1;
			}
			
		}
		
		return result;
	}
}
