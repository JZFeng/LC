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

package jz.Deprecated;

import java.util.Random;

import jz.Util;

public class ShuffleAnArray {
	private int[] nums;
	private Random random;

	public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		if (nums == null)
			return null;
		int[] a = nums.clone();
		for (int i = 0; i < a.length; i++) {
			int index = random.nextInt(i + 1);
			swap(a, i, index);
		}
		return a;
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
