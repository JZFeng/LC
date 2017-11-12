/*
 https://leetcode.com/problems/4sum-ii/#/description
 
 454. 4Sum II
 
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
package jz.Deprecated;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2 };
		int[] B = new int[] { -2, -1 };
		int[] C = new int[] { -1, 2 };
		int[] D = new int[] { 0, 2 };
		System.out.println(fourSumCount(A, B, C, D));
	}

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> ab = new HashMap<Integer, Integer>();
		for (int a : A) {
			for (int b : B) {
				if (ab.containsKey(a + b))
					ab.put(a + b, ab.get(a + b) + 1);
				else
					ab.put(a + b, 1);
			}
		}

		HashMap<Integer, Integer> cd = new HashMap<Integer, Integer>();
		for (int c : C) {
			for (int d : D) {
				if (cd.containsKey(c + d))
					cd.put(c + d, cd.get(c + d) + 1);
				else
					cd.put(c + d, 1);
			}
		}

		int count = 0;
		for (Map.Entry<Integer, Integer> entry : ab.entrySet()) {
			int tmp = -entry.getKey();
			if (cd.containsKey(tmp)) {
				count += entry.getValue() * cd.get(tmp);
			}
		}

		return count;

	}

}
