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
package jz.lc.medium;

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
		int[] nums = new int[] { 1, 2, 3 };
		subsets(nums);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	/**
	 * 
	 * @param list
	 *            final output - include result before the
	 * @param resultBeforeStart
	 *            the result before the current index
	 * @param nums
	 *            input
	 * @param start
	 *            the current index which is in the input array
	 * 
	 *            Merge the result before the index AND the result from the
	 *            current index
	 */
	static void backtrack(List<List<Integer>> list, List<Integer> resultBeforeStart, int[] nums, int start) {
		System.out.println("Current index: " + start);

		list.add(new ArrayList<>(resultBeforeStart));
		for (int i = start; i < 4; i++) {
			resultBeforeStart.add(nums[i]);
			backtrack(list, resultBeforeStart, nums, i + 1);
			resultBeforeStart.remove(resultBeforeStart.size() - 1);
			printList(resultBeforeStart);
		}
	}
	
	private static void printList(List<Integer> arraylist){
		for(Integer num : arraylist){
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
