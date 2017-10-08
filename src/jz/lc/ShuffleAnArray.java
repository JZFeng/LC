/*
 https://leetcode.com/problems/shuffle-an-array/#/solutions
 384. Shuffle an Array
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle(); 
 */

package jz.lc;

import java.util.Random;

import jz.Util;

public class ShuffleAnArray {

	public static void main(String[] args) {
		int nums[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ShuffleAnArray sfa = new ShuffleAnArray(nums);
		Util.printArray(sfa.shuffle());
		Util.printArray(randSelect(nums, 5));
	}

	private int[] nums;

	public ShuffleAnArray(int[] nums) {
		this.nums = nums;

	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return this.nums;

	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null)
			return null;

		Random rd = new Random();
		int[] nums = this.nums.clone();
		for (int j = 0; j < nums.length; j++) {
			int tmp = rd.nextInt(j + 1);
			swap(nums, tmp, j);
		}

		return nums;

	}

	public static int[] randSelect(int[] nums, int n) {
		int[] res = new int[n];
		Random rd = new Random();
		if (nums.length >= n) {
			for (int i = 0; i < n; i++) {
				swap(nums, i, rd.nextInt(nums.length - i) + i);
				res[i] = nums[i];
			}
		}

		return res;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
