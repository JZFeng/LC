package jz.NineChapter;
// http://lintcode.com/en/problem/minimum-subtree/
import jz.tree.bst.TreeNode;

public class MinimumSubtree {

	private TreeNode subtree = null;
	private int sum = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root) {
		// write your code here
		helper(root);
		return subtree;
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = helper(root.left);
		int right = helper(root.right);
		int currentSum = left + right + root.val;
		if (subtree == null || currentSum < sum) {
			subtree = root;
			sum = currentSum;
		}

		return currentSum;

	}

}
