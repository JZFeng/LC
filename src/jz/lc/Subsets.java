/**
 *
 https://leetcode.com/problems/subsets/#/description
 
 78. Subsets
 
 Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 
 */
package jz.lc;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/subsets/
 */
public class Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] {};
		ArrayList<ArrayList<Integer>> res = subsets(nums);
		for (List<Integer> list : res) {
			System.out.println(list);
		}
	}

	public static ArrayList<ArrayList<Integer>> subsets(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (nums == null) {
			return res;
		}
		if (nums.length == 0) {
			res.add(new ArrayList<Integer>());
			return res;
		}

		Arrays.sort(nums);
		ArrayList<Integer> subset = new ArrayList<Integer>();
		// 任何集合都是以空集开始的
		// 任何字符串都是以""空串开始的
		helper(nums, 0, subset, res);
		return res;

	}

	// 1. 递归的定义：从数组nums的当前位置，找出以subset为开头的所有子集，并存入res

	private static void helper(int[] nums, int start, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> res) {
		// Subset的克隆，deep copy
		ArrayList<Integer> tmp = new ArrayList<Integer>(subset);
		res.add(tmp);

		// 2. 递归的拆解
		for (int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			helper(nums, i + 1, tmp, res); // 从 [] -->[1],求出所有以1开头的子集；
			tmp.remove(tmp.size() - 1); // 回溯到初始状态, 即[1]回溯到[0];
		}

	}

}
