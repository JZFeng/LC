package jz.LadderOnly;

import java.util.ArrayList;
import java.util.List;
import jz.tree.bst.TreeNode;
//http://lintcode.com/en/problem/binary-tree-path-sum/

public class BinaryTreePathSum {

	// 其实是一个全排列问题，从根节点开始，找出所有路径
	// 然后取根到叶到路径，且和为target。存此路径到结果中。
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		List<Integer> path = new ArrayList<>();
		path.add(root.val);
		int sum = root.val;
		helper(root, target, path, sum, res);
		return res;
	}

	private void helper(TreeNode root, int target, List<Integer> path, int sum, List<List<Integer>> res) {
		if (root.left == null && root.right == null) {
			if (sum == target) {
				res.add(new ArrayList<Integer>(path));
			}
		}

		if (root.left != null) {
			path.add(root.left.val);
			helper(root.left, target, path, sum + root.left.val, res);
			path.remove(path.size() - 1);
		}

		if (root.right != null) {
			path.add(root.right.val);
			helper(root.right, target, path, sum + root.right.val, res);
			path.remove(path.size() - 1);
		}

	}

}
