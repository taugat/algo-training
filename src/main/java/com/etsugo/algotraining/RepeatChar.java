package com.etsugo.algotraining;

public class RepeatChar
{
	public static void main(String[] args)
	{
		System.out.println(getNbRep2("abc", "abccbc"));
	}
	
	//https://leetcode.com/problems/distinct-subsequences
	public static int getNbRep2(String pattern, String text)
	{
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int[] mem = new int[pattern.length()];

        for (int i = 0; i < textChars.length; i++)
        {
            char curChar = textChars[i];

            for (int y = patternChars.length - 1; y >= 1; y--)
            {
                if (0 != mem[y - 1] && curChar == patternChars[y])
                {
                    mem[y] += mem[y - 1];
                }
            }
            if (curChar == patternChars[0])
            {
                mem[0]++;
            }
        }
        return mem[pattern.length() - 1];
	}
}
