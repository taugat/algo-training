package com.etsugo.algotraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Knapsack
{
	
	public static void main(String[] args)
	{
		System.out.println(Integer.valueOf(0) + 1);
		
//		new Knapsack().canPartition(new int[]{14,9,8,4,3,2});
	}
	
	public boolean canPartition(int[] nums) {

        int total = IntStream.of(nums).sum();
        if (total % 2 != 0)
        {
            return false;
        }

        int sum = total / 2;

        List<List<Boolean>> list =
            Stream.<List<Boolean>>generate(() -> Collections.nCopies(sum + 1, null))
            .<List<Boolean>>map(ArrayList::new)
            .limit(nums.length)
            .toList();
        
        
        return hasSum(nums, 0, sum, list);
    }

    private boolean hasSum(int[] nums, int startIndex, int sum, List<List<Boolean>> list)
    {
    	
        if (0 == sum)
        {
            return true;
        }

        if (startIndex >= nums.length)
        {
            return false;
        }

        if (null == list.get(startIndex).get(sum))
        {
            int curValue = nums[startIndex];
            int newIndex = startIndex + 1; 

            if (curValue <= sum)
            {
                if (hasSum(nums, newIndex, sum - curValue, list))
                {
                    list.get(startIndex).set(sum, true);
                    return true;
                }

            }
            boolean hasSum = hasSum(nums, newIndex, sum, list);
            list.get(startIndex).set(sum, hasSum);
        }

        Boolean hasSum = list.get(startIndex).get(sum);
        System.out.println("startIndex : " + startIndex + " sum : " + sum);
        list.forEach(System.out::println);
        return null == hasSum ? false: hasSum.booleanValue();
    }
}
