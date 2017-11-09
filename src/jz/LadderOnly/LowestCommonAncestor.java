package jz.LadderOnly;

import jz.tree.bst.TreeNode;

//http://lintcode.com/en/problem/lowest-common-ancestor
public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
		// write your code here
		if (root == null || a == root || b == root) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, a, b);
		TreeNode right = lowestCommonAncestor(root.right, a, b);
		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		if (right != null) {
			return right;
		}

		return null;

	}

}
