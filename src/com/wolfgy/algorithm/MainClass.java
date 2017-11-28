package com.wolfgy.algorithm;

import java.util.Calendar;
import java.util.Date;

import com.wolfgy.algorithm.problem.BestString;

public class MainClass {

	public static void main(String[] args) {
		String input = "abavsbcddab";
		BestString bestString = new BestString();
		String output = bestString.handle(input);
		System.out.println(output);
//		LexicographicalOrdering lexicographicalOrdering = new LexicographicalOrdering();
//		lexicographicalOrdering.PermutationWithDictionary(input.toCharArray());
		Calendar today = Calendar.getInstance();
		today.set(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH),0,0,0);
		Date date = today.getTime();
		System.out.println(today);
		System.out.println(date);
	}

}
