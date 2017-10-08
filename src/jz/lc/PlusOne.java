/**
 *
 https://leetcode.com/problems/plus-one/#/description
 
 66. Plus One
 
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

 */
package jz.lc;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] a = new int[] { 8, 9, 9, 9 };
		Util.printArray(plusOne(a));

	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9)
				digits[i] = 0;
			else {
				digits[i]++;
				return digits;
			}
		}

		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		return newDigits;

	}

}
