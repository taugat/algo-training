package com.etsugo.algotraining;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class MaximumSubarray
{
	public static void main(String[] args)
	{
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
		new MaximumSubarray().maxSubArray(nums);
		new Kadane<>(Integer::sum, Integer::compare).subCollectionResult(IntStream.of(nums).boxed().toList());
	}
	
	public static class Kadane<T>
	{
		private final BinaryOperator<T> operation;
		private final Comparator<T> comparator;
		
		public Kadane(BinaryOperator<T> operation, Comparator<T> comparator)
		{
			super();
			this.operation = operation;
			this.comparator = comparator;
		}
		
		public T subCollectionResult(List<T> list)
		{
			final int[] interval = new int[] {0, 0};
			
			if (null == list || list.size() == 0)
			{
				return null;
			}
			
			ListIterator<T> iterator = list.listIterator();
			
			T finalOperationResult = iterator.next();
			
			if (iterator.hasNext())
			{
				finalOperationResult = bestOperationResult(interval, iterator, finalOperationResult);
			}
			
			System.out.println("Result : " + finalOperationResult + " start : " + interval[0] + " end : " + interval[1]);
			return finalOperationResult;
		}

		private T bestOperationResult(int[] interval, ListIterator<T> iterator, T finalOperationResult)
		{
			int lastStart = 0;
			T currentOperationResult = finalOperationResult;
			for(T curCompare = iterator.next(); iterator.hasNext(); curCompare = iterator.next())
			{
				T newOperationResult = operation.apply(currentOperationResult, curCompare);
				System.out.println("Operation on " + currentOperationResult + " and " + curCompare + " equals to " + newOperationResult);
				
				if (comparator.compare(newOperationResult, curCompare) >= 0)
				{
					System.out.println("Comparison is positive or zero on " + curCompare + " and " + newOperationResult);
					currentOperationResult = newOperationResult;
				}
				else
				{
					System.out.println("Comparison is negative on " + curCompare + " and " + newOperationResult);
					currentOperationResult = curCompare;
					lastStart = iterator.previousIndex();
				}
				System.out.println("=> Choosing " + currentOperationResult);
				
				if (comparator.compare(currentOperationResult, finalOperationResult) >= 0)
				{
					finalOperationResult = currentOperationResult;
					interval[0] = lastStart;
					interval[1] = iterator.previousIndex();
				}
				
			}
			return finalOperationResult;
		}
	}
	
    public int maxSubArray(int[] nums) {

        int maxSum, currentSum;
        int start, end;
        
        currentSum = maxSum = nums[0];
        start = end = 0;
        for(int i = 1;i < nums.length;i++)
		{
        	if (currentSum + nums[i] >= nums[i])
        	{
        		currentSum = currentSum + nums[i];
        	}
        	else
			{
				currentSum = nums[i];
				start = i;
			}
        	
        	if (maxSum <= currentSum)
        	{
        		maxSum = currentSum;
        		end = i;
        	}
		}
        System.out.println("Result : " + maxSum + " start : " + start + " end : " + end);
        return maxSum;
    }
}
