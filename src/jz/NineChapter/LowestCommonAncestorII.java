package jz.NineChapter;

import java.util.ArrayList;

//http://lintcode.com/en/problem/lowest-common-ancestor-ii/

class ParentTreeNode {
	public ParentTreeNode parent, left, right;
}

public class LowestCommonAncestorII {

	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
		if (root == null || A == root || B == root) {
			return root;
		}

		ArrayList<ParentTreeNode> listA = new ArrayList<>();
		while (A != null) {
			listA.add(A);
			A = A.parent;
		}
		ArrayList<ParentTreeNode> listB = new ArrayList<>();
		while (B != null) {
			listB.add(B);
			B = B.parent;
		}

		int indexA = listA.size() - 1;
		int indexB = listB.size() - 1;
		ParentTreeNode res = null;
		while (indexA >= 0 && indexB >= 0) {
			if (listA.get(indexA) != listB.get(indexB)) {
				break;
			} else {
				res = listA.get(indexA);
				indexA--;
				indexB--;
			}
		}

		return res;
	}

}
