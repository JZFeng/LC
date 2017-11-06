/**
https://leetcode.com/problems/single-number/#/description

136. Single Number

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 *
 */
package jz.Deprecated;

/**
 * @author jzhfeng
 * @date May 12, 2017
 */
public class SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 1, 2, 4, 5, 4, 2, 1 }));

	}

	public static int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ nums[i];
		}
		return res;
	}

}
