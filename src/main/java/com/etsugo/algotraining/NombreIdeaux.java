package com.etsugo.algotraining;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NombreIdeaux
{

	public static void main(String[] args)
	{
		nbIdeaux(100, 1000).forEach(System.out::println);
	}
	
	private static List<Integer> nbIdeaux(int start, int end)
	{
		ArrayList<Integer> nbIdeaux = new ArrayList<>();
		
		Queue<Integer> currentNbIdeaux = new PriorityQueue<>() {
			@Override
			public boolean add(Integer e)
			{
				if (e <= end)
				{
					if (e >= start)
					{
						nbIdeaux.add(e);
					}
					return super.add(e);
				}
				else
				{
					return false;
				}
			}
		};
		
        currentNbIdeaux.add(1);

        while (!currentNbIdeaux.isEmpty())
        {
            int uglySize = currentNbIdeaux.size();

            int currentUgly = 0;
            for (int i = 0; i < uglySize; i++)
            {
                currentUgly = currentNbIdeaux.poll();
                currentNbIdeaux.add(currentUgly * 3);
            }
            currentNbIdeaux.add(currentUgly * 5);
        }
        
		return nbIdeaux;
	}
}