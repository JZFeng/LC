package jz.lintcode;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 2, 2, 3, 3, 4 };
		int target = 2;
		System.out.println(firstIndex(nums, target));
		System.out.println(lastIndex(nums, target));
		System.out.println(firstIndex(nums, 3));
		System.out.println(lastIndex(nums, 3));
		System.out.println(lastIndex(nums, 4));

	}

	private static int firstIndex(int[] nums, int target) {
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
				end = mid;
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

	private static int lastIndex(int[] nums, int target) {
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
