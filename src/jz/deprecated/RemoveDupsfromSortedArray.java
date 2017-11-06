/**

https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description

26. Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.

 *
 */
package jz.deprecated;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveDupsfromSortedArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4 };
		int newSize = dedupe(nums);
		for (int i = 0; i < newSize; i++)
			System.out.print(nums[i] + " ");

	}

	public static int dedupe(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int index = 1;
		for(int i = 1 ; i < nums.length; i++) {
			if ( nums[i - 1] == nums[i]) {
				continue;
			}
			nums[index++] = nums[i];
		}
		
		return index;
	}
	
	
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// index is the end of the new array, also the position which can accept
		// new element.
		// i is the regular pointer of the array.
		// nums[index - 1] is the last unique number

		int index = 1;
		int i = 1;
		while (i < nums.length) {
			if (nums[i] == nums[index - 1])
				i++;
			else {
				nums[index] = nums[i];
				i++;
				index++;
			}
		}

		return index;

	}

}
