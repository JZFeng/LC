package jz.LadderOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class TwoSumProblems {
	// http://lintcode.com/en/problem/two-sum/
	public int[] twoSumNotSorted(int[] nums, int target) {
		int[] ans = new int[2];
		if (nums == null || nums.length < 2) {
			return ans;
		}

		HashMap<Integer, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashmap.containsKey(target - nums[i])) {
				ans[0] = hashmap.get(target - nums[i]) + 1;
				ans[1] = i + 1;
			} else {
				hashmap.put(nums[i], i);
			}
		}

		return ans;
	}

	// http://lintcode.com/en/problem/two-sum-input-array-is-sorted/
	public int[] twoSumSorted(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				int[] result = { left + 1, right + 1 };
				return result;
			} else if (sum < target) {
				left++;
			} else if (sum > target) {
				right--;
			}
		}
		return null;
	}

	// http://lintcode.com/en/problem/two-sum-data-structure-design/
	class TwoSum {

		private HashMap<Integer, Integer> hashmap = null;

		TwoSum() {
			hashmap = new HashMap<Integer, Integer>();
		}

		// Add the number to an internal data structure.
		public void add(int number) {
			if (!hashmap.containsKey(number)) {
				hashmap.put(number, 1);
			} else {
				hashmap.put(number, hashmap.get(number) + 1);
			}
		}

		// Find if there exists any pair of numbers which sum is equal to the
		// value.
		public boolean find(int value) {
			Set<Integer> set = hashmap.keySet();
			for (int key : set) {
				if (key * 2 == value && hashmap.get(key) > 1) {
					return true;
				}
				if (key * 2 != value && hashmap.containsKey(value - key)) {
					return true;
				}
			}

			return false;
		}
	}

	// http://lintcode.com/en/problem/two-sum-less-than-or-equal-to-target/
	public int twoSum5(int[] nums, int target) {
		// write your code here
		if (nums == null || nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int result = 0;
		while (left < right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else {
				result += right - left;
				left++;
			}
		}
		return result;
	}

	// http://lintcode.com/en/problem/two-sum-unique-pairs/
	public int twoSum6(int[] nums, int target) {
		int count = 0;
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] > target) {
				right--;
			} else if (nums[left] + nums[right] < target) {
				left++;
			} else {
				count++;
				left++;
				right--;
				while (left < right && nums[left] == nums[left - 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right + 1]) {
					right--;
				}
			}
		}

		return count;
	}
	// http://lintcode.com/en/problem/3sum/
	
	// http://lintcode.com/en/problem/3sum-closest/
	// http://lintcode.com/en/problem/4sum/
	// http://lintcode.com/en/problem/two-sum-closest-to-target/
	// http://lintcode.com/en/problem/two-sum-difference-equals-to-target/
	// http://lintcode.com/en/problem/two-sum-greater-than-target/
	// http://lintcode.com/en/problem/triangle-count/

}
