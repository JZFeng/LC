/**
https://leetcode.com/problems/maximum-subarray/#/description

53. Maximum Subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, 
try coding another solution using the divide and conquer approach, 
which is more subtle.
 *
 */
package jz.lc;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		Util.printArray(nums);
		System.out.println(maxSubArray(nums));

	}

	public static int maxSubArray(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int global_sum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			global_sum = Math.max(global_sum, sum);
		}
		return global_sum;

	}
	
}
