/*
 http://www.lintcode.com/en/problem/strstr-ii/
 mplement strStr function in O(n + m) time.

strStr return the first index of the target string in a source string. 
The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.
  
 */
package jz.NineChapter;

public class StrStrII {

	public static void main(String[] args) {
		String source = "abcdef";
		String target = "cde";
		System.out.println(source.indexOf(target));
		System.out.println(strStr2(source, target));

	}

	// rabin Karp
	public static int strStr2(String source, String target) {

		if (source == null || target == null)
			return -1;
		if (target.length() == 0 && source.length() > 0)
			return 0;
		if (target.length() > source.length())
			return -1;

		long BASE = Integer.MAX_VALUE / 31;
		int m = target.length();
		long target_hashcode = 0;
		for (int i = 0; i < m; i++) {
			target_hashcode = (target_hashcode * 31 + target.charAt(i)) % BASE;
		}

		// 31 ^ m
		long power = 1;
		for (int i = 0; i < m; i++) {
			power = (power * 31) % BASE;
		}

		long hashcode = 0;
		for (int i = 0; i < source.length(); i++) {
			// abc+d
			hashcode = (hashcode * 31 + source.charAt(i)) % BASE;
			if (i < m - 1) {
				continue;
			} else if (i >= m) {
				// (abc+d) - a
				hashcode = hashcode - source.charAt(i - m) * power;
				if (hashcode < 0)
					hashcode += BASE;
			}

			if (hashcode == target_hashcode) {
				if (source.substring(i - m + 1, i + 1).equals(target)) {
					return i - m + 1;
				}
			}
		}

		return -1;

	}

}
