/**
 https://leetcode.com/problems/symmetric-tree/#/description
 
 101. Symmetric Tree
 
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 
 
 */
package jz.Lintcode;

import jz.tree.bst.TreeNode;

/**
 * @author jzhfeng
 * @date May 14, 2017
 */
public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode t1 = TreeNode.fromString("1,2,2,3,4,4,3");
		TreeNode t2 = TreeNode.fromString("1,2,2,#,3,#,3");
		System.out.println(isSymmetric(t1));
		System.out.println(isSymmetric(t2));

	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isMirrored(root.left, root.right);
	}

	private static boolean isMirrored(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;

		if (left == null || right == null)
			return false;

		if (left.val != right.val)
			return false;

		return isMirrored(left.right, right.left) && isMirrored(left.left, right.right);

	}
}
