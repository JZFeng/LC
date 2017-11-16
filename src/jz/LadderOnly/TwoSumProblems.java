package jz.LadderOnly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				int tmp = -nums[i];
				if (sum == tmp) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right + 1] == nums[right]) {
						right--;
					}
				} else if (sum > tmp) {
					right--;
				} else {
					left++;
				}
			}
		}

		return res;
	}

	// http://lintcode.com/en/problem/two-sum-closest-to-target
	public int twoSumClosest(int[] nums, int target) {
		// write your code here
		if (nums == null || nums.length < 2) {
			return -1;
		}

		// 要求全局的Two Sum closest，那么就要打个擂台。
		// 设置一个全局变量 bestSum;
		Arrays.sort(nums);
		int bestSum = nums[0] + nums[1];
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
				bestSum = sum;
			}

			if (sum == target) {
				return 0;
			} else if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			}
		}

		return Math.abs(bestSum - target);
	}

	// http://lintcode.com/en/problem/3sum-closest/
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) {
			return -1;
		}

		// closest means the Math.abs(sum - target) is smallest.
		// 既然要求smallest，就要有一个全局变量用来打擂台。
		Arrays.sort(nums);
		int bestsum = nums[0] + nums[1] + nums[2];
		// 固定一边，剩下的区间内，求two sum；
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				// 打个擂台
				int sum = nums[i] + nums[left] + nums[right];
				if (Math.abs(sum - target) < Math.abs(bestsum - target)) {
					bestsum = sum;
				}
				if (sum == target) {
					return sum;
				} else if (sum > target) {
					right--;
				} else if (sum < target) {
					left++;
				}
			}
		}

		return bestsum;
	}

	// http://lintcode.com/en/problem/two-sum-difference-equals-to-target/
	public int[] twoSum7(int[] nums, int target) {
		// write your code here
		int[] res = new int[2];
		if (nums == null || nums.length < 2) {
			return res;
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && target == 0) {
				res[0] = i + 1;
				res[1] = map.get(nums[i]) + 1;
				Arrays.sort(res);
				return res;
			}
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] + target)) {
				res[0] = i + 1;
				res[1] = map.get(nums[i] + target) + 1;
				Arrays.sort(res);
				return res;
			} else {
				continue;
			}
		}

		return res;

	}

	// http://lintcode.com/en/problem/two-sum-greater-than-target/
	public int twoSum2(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		Arrays.sort(nums);
		int count = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum > target) {
				count += right - left;
				right--;
			} else {
				left++;
			}
		}

		return count;
	}

	// http://lintcode.com/en/problem/triangle-count/
	// 形成三角形的条件是两边之和大于第三边；
	// 排序过后的数组，如果a[i] + a[i + 1] > a[i + 2]，很显然任意两数相加都大于第三个数；
	public int triangleCount(int[] nums) {
		int count = 0;
		if (nums == null || nums.length < 3) {
			return count;
		}

		Arrays.sort(nums);
		// 固定一边,求剩下的范围内，有多少pair，他们的和大于第三个数
		for (int i = 2; i < nums.length; i++) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				int sum = nums[left] + nums[right];
				if (sum <= nums[i]) {
					left++;
				} else {
					count += (right - left);
					right--;
				}
			}
		}

		return count;
	}

	// http://lintcode.com/en/problem/4sum/
	public class Solution {

		public List<List<Integer>> fourSum(int[] nums, int target) {
			List<List<Integer>> res = new ArrayList<>();
			if (nums == null || nums.length < 4) {
				return res;
			}

			Arrays.sort(nums);
			for (int i = 0; i < nums.length - 3; i++) {
				if (i != 0 && nums[i] == nums[i - 1]) {
					continue;
				}
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j != i + 1 && nums[j] == nums[j - 1]) {
						continue;
					}
					int left = j + 1;
					int right = nums.length - 1;
					while (left < right) {
						int tmp = target - nums[i] - nums[j];
						int sum = nums[left] + nums[right];
						if (sum == tmp) {
							List<Integer> list = new ArrayList<>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[left]);
							list.add(nums[right]);
							res.add(list);
							left++;
							right--;
							while (left < right && nums[left] == nums[left - 1]) {
								left++;
							}
							while (left < right && nums[right] == nums[right + 1]) {
								right--;
							}
						} else if (sum > tmp) {
							right--;
						} else {
							left++;
						}
					}
				}
			}

			return res;
		}
	}

}
