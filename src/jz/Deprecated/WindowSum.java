package jz.Deprecated;

//http://lintcode.com/en/problem/window-sum/
public class WindowSum {

	public int[] winSum(int[] nums, int k) {
		if (nums.length == 0 && k == 0) {
			return new int[] {};
		}

		int length = nums.length - k + 1;
		int[] res = new int[length];
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += nums[i];
		}
		res[0] = sum;

		for (int i = k; i < nums.length; i++) {
			res[i - k + 1] = res[i - k] + nums[i] - nums[i - k];
		}

		return res;
	}

}
