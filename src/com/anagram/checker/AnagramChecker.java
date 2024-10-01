package com.anagram.checker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnagramChecker {

	public static void main(String[] args) {
		System.out.println(areAnagrams("listen", "silent")); // true
        System.out.println(areAnagrams("triangle", "integral")); // true
        System.out.println(areAnagrams("apple", "pale")); // false
        System.out.println(areAnagrams("Hello", "Olelh")); // true
        System.out.println(areAnagrams("Astronomer", "Moon starer")); // true (case-insensitive and ignores spaces)
	
        String[] strs = {"eat","nat","tea","ate","ant","bat"};
        List<Set<String>> result = new ArrayList<>();
        
        Map<String, Set<String>> map = new HashMap<>(); 
        
        for(int index =0 ; index < strs.length-1 ; index++) {
        	Set<String> sub = new HashSet<>();
        	for(int j =0 ; j < index; j++) {
        		boolean result1 = areAnagrams(strs[index], strs[j]);

        		if(map.containsKey(strs[index])) {
        			map.get(strs[index]).add(strs[j]);
        		}else {
        			sub.add(strs[j]);
        			map.put(strs[index], sub);
        		}
        		
        		sub.add(strs[index]);
        		if(result1) {
        			sub.add(strs[j]);
        		}
        		
        	}
        	if(!sub.isEmpty())
        		result.add(sub);
        }
        
        System.out.println(map.values());
        
        
        
        
        
	System.out.println(areAnagram(strs));
	System.out.println(areAna(strs));
	}
	
	public static List<List<String>> areAna(String[] words){
		// Create a map to hold sorted character sequences as keys and words as values
        Map<String, List<String>> anagramMap = new HashMap<>();
        
        // Loop through each word in the input array
        for (String word : words) {
            // Convert the word into a char array and sort it to form the key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            
            // Add the word to the correct anagram group in the map
            anagramMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }
        
        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(anagramMap.values());
	}
	
	public static List<List<String>> areAnagram(String[] strs){
		List<List<String>> result = new ArrayList<>();
		Map<List<Character>, List<String>> charsMap = new HashMap<>();
		for(String str:strs) {
			List<Character> chars = new ArrayList<>();
			for(char ch : str.toCharArray()) {
				chars.add(ch);
			}
			Collections.sort(chars);
			if(charsMap.containsKey(chars)) {
				charsMap.get(chars).add(str);
			}else {
				List<String> list = new ArrayList<>();
				list.add(str);
				charsMap.put(chars, list);
				result.add(list);
			}
			
		}
		return result;
	}

	public static boolean areAnagrams(String str1, String str2) {
		
		/*
		Map<List<Character>, List<String>> charsMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String string : strs) {
            List<Character> chars = new ArrayList<>();
            for (char c : string.toCharArray()) {
                chars.add(c);
            }
          Collections.sort(chars);
          if (charsMap.containsKey(chars)) {
                charsMap.get(chars).add(string);
          } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                charsMap.put(chars, list);
                result.add(list);
          }
        }
        return result;
*/
		
		str2=str2.replace(" ", "");
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		int[] charCount = new int[256];
		
		for(char ch : str1.toCharArray()) {
			charCount[ch]++;
		}
		
		for(char ch : str2.toCharArray()) {
			charCount[ch]--;
		}
		
		for(int count : charCount) {
			if(count != 0) {
				return false;
			}
		}
		
		return true;
	}
}
