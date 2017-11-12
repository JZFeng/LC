package jz.LadderOnly;

/*
 * http://lintcode.com/en/problem/total-occurrence-of-target/
 */
public class TotalOccurrenceofTarget {

	public int totalOccurrence(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int firstIndex = firstIndex(nums, target);
		int lastIndex = lastIndex(nums, target);

		if (firstIndex != -1 && lastIndex != -1) {
			return lastIndex - firstIndex + 1;
		}

		return 0;

	}

	private int firstIndex(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;
			} else if (nums[mid] > target) {
				end = mid;
			} else if (nums[mid] < target) {
				start = mid;
			}
		}

		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}

		return -1;
	}

	private int lastIndex(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > target) {
				end = mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				start = mid;
			}
		}

		if (nums[end] == target) {
			return end;
		}
		if (nums[start] == target) {
			return start;
		}

		return -1;

	}

}
