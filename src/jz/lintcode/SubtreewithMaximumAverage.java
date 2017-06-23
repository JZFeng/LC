package jz.lintcode;

import jz.tree.bst.TreeNode;

public class SubtreewithMaximumAverage {

	private class ResultType {
		int size;
		int sum;

		ResultType(int sum, int size) {
			this.sum = sum;
			this.size = size;
		}
	}

	private TreeNode subtree = null;
	private ResultType subtreeResult = null;

	public TreeNode findSubtree2(TreeNode root) {
		helper(root);
		return subtree;
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, 0);
		}

		ResultType leftResult = helper(root.left);
		ResultType rightResult = helper(root.right);
		int rootSum = leftResult.sum + rightResult.sum + root.val;
		int rootSize = leftResult.size + rightResult.size + 1;
		ResultType rootResult = new ResultType(rootSum, rootSize);

		if (subtree == null || subtreeResult.sum * rootResult.size < subtreeResult.size * rootResult.sum) {
              //subtreeResult.sum / subtreeResult.size < rootResult.sum / rootResult.size
			subtree = root;
			subtreeResult = rootResult;
		}

		return rootResult;
	}

}
