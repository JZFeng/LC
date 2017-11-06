/**
 https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description
 
80. Remove Duplicates from Sorted Array II
 
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, 
with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.

Answer: http://www.cnblogs.com/ganganloveu/p/3737536.html?utm_source=tuicool&utm_medium=referral
 *
 */
package jz.Deprecated;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveDupfromSortedArrayII {

	public static void main(String[] args) {
		// 1,1,1,1,2,2,2,2,3,3,3
		int[] nums = new int[] { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3 };
		ArrayList<Integer> a = new ArrayList<>();
		a.add(5);
		a.add(3);
		System.out.println(a.contains(3));

		int newSize = dedupeII(nums);
		for (int i = 0; i < newSize; i++)
			System.out.print(nums[i] + " ");

	}

	public static int dedupeII(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length <= 2)
			return nums.length;

		int index = 2;
		for (int i = 2; i < nums.length; i++) {
			if (nums[i] == nums[index - 2]) {
				continue;
			}

			nums[index++] = nums[i];
		}

		return index;
	}

	public static int removeDuplicatesII(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length < 3)
			return nums.length;

		// index is the end of the new array, also is the position that can
		// accept the number that appears less than
		// twice.
		// i is the regular pointer to go through the array.
		// nums[index-2] is the last number that appears less than twice.(2
		// included)

		int index = 2;
		int i = 2;
		while (i < nums.length) {
			if (nums[i] == nums[index - 2])
				i++;
			else {
				nums[index] = nums[i];
				i++;
				index++;
			}
		}
		return index;
	}

	// duplicates are allowed at most K times
	public static int removeDuplicatesII(int[] nums, int k) {
		if (nums == null)
			return 0;
		if (nums.length <= k)
			return nums.length;

		int index = k;
		int i = k;

		while (i < nums.length) {
			if (nums[i] == nums[index - k])
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
