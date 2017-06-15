/*
 http://www.lintcode.com/en/problem/subsets/ 
 */
package jz.lintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		ArrayList<ArrayList<Integer>> ans = subsets(nums);
		for (ArrayList<Integer> a : ans) {
			System.out.println(a);
		}

	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (nums == null) {
			return ans;
		}
		if (nums.length == 0) {
			ans.add(new ArrayList<Integer>());
			return ans;
		}

		Arrays.sort(nums);
		ArrayList<Integer> subset = new ArrayList<>(); // start from [], NOT
														// [nums[0]];
		helper(nums, 0, subset, ans);

		return ans;
	}

	private static void helper(int[] nums, 
							   int start, 
							   ArrayList<Integer> subset, 
							   ArrayList<ArrayList<Integer>> ans) {
		
		ArrayList<Integer> tmp = new ArrayList<>(subset); // hard copy;
		ans.add(tmp);
		for (int i = start; i < nums.length; i++) { // Attention!!! i = start
													// NOT i = 0
			tmp.add(nums[i]);
			helper(nums, i + 1, tmp, ans);
			tmp.remove(tmp.size() - 1); // backtracking
		}
	}
}
