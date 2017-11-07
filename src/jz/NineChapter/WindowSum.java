package jz.NineChapter;

//http://lintcode.com/en/problem/window-sum/
public class WindowSum {

	public int[] winSum(int[] nums, int k) {
		// write your code here
		if (nums == null || nums.length < k || k <= 0) {
			return new int[0];
		}
		int sum = 0;
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			sum = sum + nums[i];
		}
		result[0] = sum;
		for (int i = k; i < nums.length; i++) {
			result[i - k + 1] = result[i - k] - nums[i - k] + nums[i];
		}
		return result;
	}

}
