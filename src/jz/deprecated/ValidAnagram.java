/*
https://leetcode.com/problems/valid-anagram/#/description

242. Valid Anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */
package jz.deprecated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagramBucketSort("rat", "car"));

	}

	public static boolean isAnagramBucketSort(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] alphabetic = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			alphabetic[index]++;
		}

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			int index = c - 'a';
			alphabetic[index]--;
		}

		for (int i : alphabetic) {
			if (i != 0)
				return false;
		}

		return true;
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (hm.containsKey(c))
				hm.replace(c, hm.get(c).intValue() + 1);
			else
				hm.put(c, 1);
		}

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!hm.containsKey(c))
				return false;
			else
				hm.replace(c, hm.get(c).intValue() - 1);
		}

		Collection<Integer> al = hm.values();

		for (Integer i : al) {
			if (i != 0)
				return false;
		}

		return true;
	}

}
