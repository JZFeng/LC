package jz.NineChapter;

//http://lintcode.com/en/problem/kth-smallest-numbers-in-unsorted-array/
public class KthSmallestNumbersInUnsortedArray {

	/*
	 * @param k: An integer
	 * 
	 * @param nums: An integer array
	 * 
	 * @return: kth smallest element
	 */
	public int kthSmallest(int k, int[] nums) {
		return quickSelect(nums, k, 0, nums.length - 1);
	}

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
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
			// left;
		}

		if (start + k - 1 <= right) {
			return quickSelect(nums, k, start, right);
		}
		if (start + k - 1 >= left) {
			return quickSelect(nums, k - (left - start), left, end);
		}

		return nums[left - 1];
	}

}
