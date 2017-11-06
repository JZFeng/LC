/**
 https://leetcode.com/problems/single-number-ii/#/description
 
 137. Single Number II
 
Given an array of integers, every element appears three times except for one, 
which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?


 */
package jz.Deprecated;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 17, 2017
 */
public class SingleNumberII {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 1, 4, 5, 1, 4, 2, 2, 4, 1 };
		System.out.println(singleNumber(a));

	}

	public static int singleNumber(int[] A) {
		int[] bitCount = new int[32];
		int res = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				bitCount[i] = bitCount[i] + (A[j] >> i & 1);
			}

			res |= (bitCount[i] % 3) << i;

		}
		return res;
	}
}
