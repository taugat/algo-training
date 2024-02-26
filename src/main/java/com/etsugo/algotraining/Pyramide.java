package com.etsugo.algotraining;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

/*   <-> c
 *   1
 * ^ 1 1
 * | 1 2 1
 * v 1 3 3 1
 * l 1 4 6 4 1
 *   ...
 *   
 * get(l, c) == get(l-1, c-1) + get(l-1, c); get(0, 0) == 1
 * 
 */
public class Pyramide
{
	private static Map<Integer, BigInteger> knownFact = new TreeMap<>(Collections.reverseOrder());
	static
	{
		knownFact.put(1, BigInteger.ONE);
	}
	
	public static void main(String[] args)
	{
		System.out.println(get(10_000, 5_000));
		//14226520737620288370
		//14226520737620288370
	}
	
	private static String get(int l, int c)
	{
		if (c == 0 || l == c)
		{
			return "1";
		}
		
		int diff = l - c;
		BigInteger bigResult;
		if (diff > c)
		{
			bigResult = fact(c);
			bigResult = bigResult.multiply(fact(diff));
		}
		else
		{
			bigResult = fact(diff);
			bigResult = bigResult.multiply(fact(c));
		}
		
		bigResult = fact(l).divide(bigResult);
		
		return bigResult.toString();
	}

	private static BigInteger fact(int c)
	{
		int i;
		BigInteger fact;
		
		Optional<Entry<Integer, BigInteger>> maxFactUnderC =
			knownFact.entrySet().stream()
				.filter(entry -> entry.getKey() < c)
				.max(Comparator.comparingInt(Entry<Integer, BigInteger>::getKey))
				;
		
		if (maxFactUnderC.isPresent())
		{
			Entry<Integer, BigInteger> entry = maxFactUnderC.get();
			i = entry.getKey();
			fact = entry.getValue();
		}
		else
		{
			i = 1;
			fact = BigInteger.ONE;
		}
		
//		IntStream.rangeClosed(i, c).redu
		
		for (; i <= c; i++)
		{
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		
		return fact;
	}
}
