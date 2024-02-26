package com.etsugo.algotraining;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class AsciiArtToLetter
{
	
	static private Map<String, Character> mapAsciiToChar = IntStream.rangeClosed('A', 'Z')
		.collect(HashMap::new
			, (map, i) -> map.put(AsciiArtToLetter.asciiValue((char) i), (char) i)
			, Map::putAll);
	
	public static void main(String[] args)
	{
		mapAsciiToChar.forEach((a,b) -> System.out.println(a + ": "+b));
	}

	private static String asciiValue(char t1)
	{
		return t1 + "";
	}
}
