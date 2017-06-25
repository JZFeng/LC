package jz.lintcode;

import java.util.ArrayList;
import java.util.List;

import jz.tree.bst.TreeNode;

public class BinaryTreePathSumII {
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(root.val);
		dfs(res, path, root, target, root.val);
		return res;
	}

	private void dfs(List<List<Integer>> res, ArrayList<Integer> path, TreeNode root, int target, int sum) {
		// 遇到叶子节点的返回条件
		if (root.left == null && root.right == null) {
			if (sum == target) {
				res.add(new ArrayList<Integer>(path));
			}
			return;
		}

		if (root.left != null) {
			path.add(root.left.val);
			dfs(res, path, root.left, target, sum + root.left.val);
			path.remove(path.size() - 1);
		}

		if (root.right != null) {
			path.add(root.right.val);
			dfs(res, path, root.right, target, sum + root.right.val);
			path.remove(path.size() - 1);
		}
	}
}
