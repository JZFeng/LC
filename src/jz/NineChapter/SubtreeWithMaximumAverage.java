package jz.NineChapter;

import jz.tree.bst.TreeNode;

//http://lintcode.com/en/problem/subtree-with-maximum-average/

public class SubtreeWithMaximumAverage {

	class ReturnType {
		int sum;
		int count;
		
		ReturnType(int sum, int count) {
			this.sum = sum;
			this.count = count;
		}
	}
	private TreeNode maxSubtree = null;
	private ReturnType maxAverage = null;

	public TreeNode findSubtree2(TreeNode root) {
		helper(root);
		return maxSubtree;
	}

	private ReturnType helper(TreeNode root) {
		if (root == null) {
			return new ReturnType(0, 0);
		}

		ReturnType left = helper(root.left);
		ReturnType right = helper(root.right);

		ReturnType tmp = new ReturnType(left.sum + right.sum + root.val, left.count + right.count + 1);

		if (maxAverage == null || tmp.sum * maxAverage.count > maxAverage.sum * tmp.count) {
			maxAverage = tmp;
			maxSubtree = root;
		}

		return tmp;
	}

}
