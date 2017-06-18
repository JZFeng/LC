/*
 http://www.lintcode.com/en/problem/recover-rotated-sorted-array/ 
 */
package jz.lintcode;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {

	public static void main(String[] args) {
		int[] a = new int[] { 1,2,3 };
		ArrayList<Integer> nums = new ArrayList<>();
		for (int num : a) {
			nums.add(num);
		}

		System.out.println(findMin(nums));

		System.out.println(nums);
		int min = findMin(nums);
		rotate(nums, 0, min - 1);
		rotate(nums, min, nums.size() - 1);
		rotate(nums, 0, nums.size() - 1);
		System.out.println(nums);

	}

	/**
	 * @param nums:
	 *            The rotated sorted array
	 * @return: void
	 */
	public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if (nums == null || nums.size() <= 1) {
			return;
		}

		int min = findMin(nums);
		rotate(nums, 0, min - 1);
		rotate(nums, min, nums.size() - 1);
		rotate(nums, 0, nums.size() - 1);

	}

	private static void rotate(ArrayList<Integer> nums, int start, int end) {
		while (start < end) {
			int tmp = nums.get(start);
			nums.set(start, nums.get(end));
			nums.set(end, tmp);
			start++;
			end--;
		}

	}

	private static int findMin(ArrayList<Integer> nums) {
		int i = 1;
		while( i < nums.size()) {
			if( nums.get(i) >= nums.get( i - 1)){
				i++;
			} else {
				break;
			}
		}
		
		if( i == nums.size()) {
			return 0;
		} else {
			return i;
		}
		
		
	}

}
