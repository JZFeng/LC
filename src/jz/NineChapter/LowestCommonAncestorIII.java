package jz.NineChapter;

import jz.tree.bst.TreeNode;

//http://lintcode.com/en/problem/lowest-common-ancestor-iii
public class LowestCommonAncestorIII {

	class ReturnType {
		boolean hasA;
		boolean hasB;
		TreeNode lca;

		ReturnType(boolean hasA, boolean hasB, TreeNode lca) {
			this.hasA = hasA;
			this.hasB = hasB;
			this.lca = lca;
		}
	}

	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
		ReturnType tmp = lca(root, A, B);
		if (tmp.hasA && tmp.hasB) {
			return tmp.lca;
		} else {
			return null;
		}
	}

	private ReturnType lca(TreeNode root, TreeNode A, TreeNode B) {
		if (root == null) {
			return new ReturnType(false, false, null);
		}

		ReturnType left = lca(root.left, A, B);
		ReturnType right = lca(root.right, A, B);
		boolean hasA = left.hasA || right.hasA || A == root;
		boolean hasB = left.hasB || right.hasB || B == root;
		if (A == root || B == root) {
			return new ReturnType(hasA, hasB, root);
		}
		if (left.lca != null && right.lca != null) {
			return new ReturnType(hasA, hasB, root);
		}
		if (left.lca != null) {
			return new ReturnType(hasA, hasB, left.lca);
		}
		if (right.lca != null) {
			return new ReturnType(hasA, hasB, right.lca);
		}

		return new ReturnType(hasA, hasB, null);

	}
}
