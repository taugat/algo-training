package com.etsugo.algotraining;

import java.util.ArrayDeque;
import java.util.Deque;

public class OpenCloseBrackets
{
	public static void main(String[] args)
	{
		System.out.println(check("[[[{coucou}toto]]]"));
	}
	
	static boolean check(String str)
	{
		Deque<Character> wantedChar = new ArrayDeque<>(str.length()/2);
		for(int i = 0;i < str.length();i++)
		{
			char curChar = str.charAt(i);
			switch (curChar)
			{
				case '(' -> wantedChar.add(')');
				case '[' -> wantedChar.add(']');
				case ')', ']' -> {
					if (Character.valueOf(curChar) != wantedChar.pollLast()) return false;
				}
			}
		}
		return 0 == wantedChar.size();
	}
}
