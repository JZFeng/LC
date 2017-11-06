/*
https://leetcode.com/problems/majority-element/#/description

169. Majority Element

Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

 */
package jz.Lintcode;

import java.util.Arrays;
import java.util.HashMap;

import jz.Util;

public class MajorityElement {

	public static void main(String[] args) {
		int[] a = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElementMoorVoting(a));

	}

	public static int majorityElement(int[] nums) {
		int size = nums.length;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(Integer.valueOf(nums[i]))) {
				hm.replace(nums[i], hm.get(nums[i]) + 1);
			} else
				hm.put(nums[i], 1);

			if (hm.get(nums[i]).intValue() > size / 2)
				return nums[i];

		}

		return Integer.MIN_VALUE;

	}

	public static int majorityElementMoorVoting(int[] nums) {
		int count = 0, candidate = 0;
		for (int num : nums) {
			if (count == 0)
				candidate = num;
			if (num != candidate)
				count--;
			else
				count++;
		}
		return candidate;
	}

}
