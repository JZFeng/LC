/**
 https://leetcode.com/problems/move-zeroes/#/description
 
 283. Move Zeroes
 
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
1 You must do this in-place without making a copy of the array.
2 Minimize the total number of operations.

 */
package jz.lc;

import java.util.HashSet;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 11, 2017
 */
public class MoveZeroes {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<>();

		int[] a = new int[] { 0, 1, 0, 3, 12 };
		Util.printArray(a);
		moveZeroes(a);
		Util.printArray(a);

	}

	public static void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] == 0) {
				j++;
			} else {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j++;
			}
		}
	}

}
