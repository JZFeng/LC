/*
 215. Kth Largest Element in an Array
 https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
  
 */
package jz.Deprecated;

import java.util.Comparator;
import java.util.PriorityQueue;

import jz.Util;

public class KthLargestElementinanArray {

	public int kthLargestElement(int k, int[] nums) {
		// quick select algorithm, O(N);
		if (nums == null || nums.length == 0) {
			return Integer.MIN_VALUE;
		}

		k = nums.length - k + 1;

		return quickSelect(nums, k, 0, nums.length - 1);
	}

	// select K smallest element from the array;
	private int quickSelect(int[] nums, int k, int start, int end) {
		if (start == end) {
			return nums[start];
		}

		int left = start;
		int right = end;
		int pivot = nums[left + (right - left) / 2];
		while (left <= right) {
			while (left <= right && nums[left] < pivot) {
				left++;
			}
			while (left <= right && nums[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}

		if (start + k - 1 <= right) {
			return quickSelect(nums, k, start, right);
		}
		if (start + k - 1 >= left) {
			return quickSelect(nums, k - (left - start), left, end);
		}

		return nums[left - 1];
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
