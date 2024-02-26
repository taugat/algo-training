package com.etsugo.algotraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopoSort
{
	public static void main(String[] args)
	{
		new TopoSort().canFinish(5, new int[][] {{1,4},{2,4},{3,1},{3,2}});
	}
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> sortedList = new ArrayList<>();

        List<List<Integer>> parents = Stream.<List<Integer>>generate(ArrayList::new)
            .limit(numCourses)
            .collect(Collectors.toList());
        
        List<Integer> childs = new ArrayList<>(Collections.<Integer>nCopies(numCourses, 0));

        for (int[] prerequisite : prerequisites)
        {
            int parent = prerequisite[0];
            int child = prerequisite[1];

            parents.get(parent).add(child);
            childs.set(child, childs.get(child) + 1);
        }
        
        parents.forEach(System.out::println);

        Queue<Integer> sources = new LinkedList<>();

        for (int i = 0; i < childs.size(); i++)
        {
            if (0 == childs.get(i))
            {
                sources.offer(i);
            }
        }
        
        System.out.println(childs);

        while(!sources.isEmpty())
        {
            int source = sources.remove();
            System.out.println(source);
            sortedList.add(source);
            List<Integer> currentChilds = parents.get(source);
            for (int child : currentChilds)
            {
                childs.set(child, childs.get(child) - 1);
                System.out.println(child + " " + childs.get(child));
                if (0 == childs.get(child))
                {
                	sources.add(child);
                }
            }
        }
        
        System.out.println(sortedList);

        return sortedList.size() == numCourses;
    }
}
