package jz.Lintcode;

public class MaxDifferenceInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxDiff(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int max_diff = Integer.MIN_VALUE;
		int min = nums[0];
		for (int i = 0; i < nums.length; i++) {
			max_diff = Math.max(max_diff, nums[i] - min);
			min = Math.min(min, nums[i]);
		}

		return max_diff;

	}

}
