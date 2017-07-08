package jz.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String s = "aab";
		List<List<String>> results = partition(s);
		for(List<String> a : results) {
			System.out.println(a);
		}

		HashMap<Character, Integer> hashmap = new HashMap<>();
	}

	public static List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<>();
		if (s == null) {
			return results;
		}
		if (s.length() == 0) {
			results.add(new ArrayList<String>());
			return results;
		}

		ArrayList<String> partition = new ArrayList<String>();
		helper(s, 0, partition, results);
		return results;
	}

	private static void helper(String s, int startIndex, ArrayList<String> partition, List<List<String>> results) {
		if (startIndex == s.length()) {
			results.add(new ArrayList<String>(partition));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			String substring = s.substring(startIndex, i + 1);
			if (!isPalindrome(substring)) {
				continue;
			}

			partition.add(substring);
			helper(s, i + 1, partition, results);
			partition.remove(partition.size() - 1);
		}

	}

	private static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (!(s.charAt(i) == s.charAt(j))) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

}
