package jz.NineChapter;

//http://lintcode.com/en/problem/maximum-number-in-mountain-sequence/
public class MaximumNumberInMountainSequence {

	public int mountainSequence(int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return nums[mid];
			} else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
				start = mid;
			} else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				end = mid;
			}
		}
		if (nums[start] > nums[end]) {
			return nums[start];
		} else {
			return nums[end];
		}
	}

}
