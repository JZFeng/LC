package jz.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> ans = permuteUnique(nums);
		for (List<Integer> a : ans) {
			System.out.println(a);
		}

	}

	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: A list of unique permutations.
	 */
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null) {
			return ans;
		}
		if (nums.length == 0) {
			ans.add(new ArrayList<Integer>());
			return ans;
		}

		ArrayList<Integer> subset = new ArrayList<>();
		int[] isVisited = new int[nums.length];
		permuteHelper(nums, subset, isVisited, ans);

		return ans;
	}

	private static void permuteHelper(int[] nums, ArrayList<Integer> subset, int[] isVisited, List<List<Integer>> ans) {
		Arrays.sort(nums);
		ArrayList<Integer> tmp = new ArrayList<>(subset);
		if (tmp.size() == nums.length) {
			ans.add(tmp);
		}

		for (int i = 0; i < nums.length; i++) {
			if (isVisited[i] == 1 || i != 0 && nums[i] == nums[i - 1] && isVisited[i - 1] == 1) {
				continue;
			}

			isVisited[i] = 1;
			tmp.add(nums[i]);
			permuteHelper(nums, tmp, isVisited, ans);
			tmp.remove(tmp.size() - 1);
			isVisited[i] = 0;
		}

	}

}
