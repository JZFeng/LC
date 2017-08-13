/*
 https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/#/description
 
 108. Convert Sorted Array to Binary Search Tree
 
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
  
 */
package jz.lc.easy;

import jz.tree.bst.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = sortedArrayToBST(array);
		System.out.println(TreeNode.toString(root));

	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length - 1);

	}

	private static TreeNode helper(int[] nums, int left, int right) {
		if (nums == null || nums.length == 0)
			return null;

		if (left > right)
			return null;
		if (left == right)
			return new TreeNode(nums[left]);

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, left, mid - 1);
		root.right = helper(nums, mid + 1, right);

		return root;
	}
}
