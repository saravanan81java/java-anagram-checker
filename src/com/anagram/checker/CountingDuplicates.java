package com.anagram.checker;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicates {
	public static void main(String[] args) {
		  System.out.println(countDuplicates("abcde")); // 0
	        System.out.println(countDuplicates("aabbcde")); // 2
	        System.out.println(countDuplicates("aabBcde")); // 2
	        System.out.println(countDuplicates("indivisibility")); // 1
	        System.out.println(countDuplicates("Indivisibilities")); // 2
	        System.out.println(countDuplicates("aA11")); // 2
	        System.out.println(countDuplicates("ABBA")); // 2

	}

	private static int countDuplicates(String string) {
		Map<Character, Long> map = string.toLowerCase().chars()
		.mapToObj(ch -> (char) ch )
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		int dup = 0;
		for(Long values : map.values()) {
			if(values> 1) {
				dup++;
			}
		}
		
		Map<Character, Long> re = new HashMap<>();
		
		for(char ch : string.toCharArray()) {
			if(re.containsKey(ch)){
				re.put(ch, re.get(ch)+1);
			}else {
				re.put(ch, 1L);
			}
		}
		
		return dup;
	}
}
