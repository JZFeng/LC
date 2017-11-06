package jz.lc.jiuzhang;
/*
 http://lintcode.com/en/problem/closest-number-in-sorted-array/
 Closest Number in Sorted Array 

Given a target number and an integer array A sorted in ascending order, 
find the index i in A such that A[i] is closest to the given target.

Return -1 if there is no element in the array.

Notice:
There can be duplicate elements in the array, and we can return any of the indices with same value.

Example
Given [1, 2, 3] and target = 2, return 1.

Given [1, 4, 6] and target = 3, return 1.

Given [1, 4, 6] and target = 5, return 1 or 2.

Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.

 */


public class ClosestNumberinSortedArray {

	public static void main(String[] args) {

	}

	public int closestNumber(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (Math.abs(nums[left] - target) < nums[right] - target) {
			return left;
		} else {
			return right;
		}

	}
}
