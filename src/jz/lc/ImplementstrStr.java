/**
https://leetcode.com/problems/implement-strstr/#/description

28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack,

or -1 if needle is not part of haystack.

 
 */
package jz.lc;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class ImplementstrStr {

	public static void main(String[] args) {

		String haystack = "abababababcdabcdef";
		String needle = "abc";
		System.out.println(haystack.indexOf(needle));
		System.out.println(strStr(haystack, needle));

	}

	// Use two pointers. Every time when it does not match, reset j = 0; i = i -
	// (j-1);
	public static int strStr(String source, String target) {
		if (source == null || target == null)
			return -1;

		for (int i = 0; i < source.length() - target.length() + 1; i++) {
			int j = 0; // 这步很关键，因为要重置target串
			for (j = 0; j < target.length(); j++) {
				if (source.charAt(i + j) != target.charAt(j)) {
					break;
				}
			}

			if (j == target.length())
				return i;
		}

		return -1;
	}

}
