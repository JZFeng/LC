/**

https://leetcode.com/problems/merge-sorted-array/#/description

88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 

The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
package jz.lc.easy;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 4, 5, 6, 0 };

		int[] nums2 = new int[] { 3 };

		merge(nums1, 5, nums2, nums2.length);
		Util.printArray(nums1);

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (n == 0)
			return;

		int i = m - 1;
		int j = n - 1;
		int index = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[index--] = nums1[i--];
			} else {
				nums1[index--] = nums2[j--];
			}
		}

		while (j >= 0) {
			nums1[index--] = nums2[j--];
		}
		while (i >= 0) {
			nums1[index--] = nums1[i--];
		}
	}

}
