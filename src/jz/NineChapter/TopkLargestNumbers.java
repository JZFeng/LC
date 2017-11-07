package jz.NineChapter;

//http://lintcode.com/en/problem/top-k-largest-numbers/
public class TopkLargestNumbers {

	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, nums.length - k + 1, 0, nums.length - 1);
	}

	// find kth smallest element;
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

	private void swap(int[] nums, int left, int right) {
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}

}
