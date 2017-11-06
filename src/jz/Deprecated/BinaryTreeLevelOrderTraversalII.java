/*
 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/#/description
 107. Binary Tree Level Order Traversal II
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
] 
 */
package jz.Deprecated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jz.tree.bst.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	public static void main(String[] args) {

		TreeNode root = TreeNode.fromString("3,9,20,#,#,15,7");

		List<List<Integer>> res = levelOrderBottom(root);
		for (List<Integer> a : res) {
			Iterator<Integer> itr = a.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> res = new LinkedList<List<Integer>>();

		if (root == null)
			return res;

		TreeNode cur = root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> curLevel = new ArrayList<Integer>();
		List<Integer> nextLevel = new ArrayList<Integer>();
		int numCur = 1;
		int numNext = 0;
		queue.offer(cur);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			curLevel.add(tmp.val);
			numCur--;

			if (tmp.left != null) {
				queue.offer(tmp.left);
				numNext++;
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
				numNext++;
			}

			if (numCur == 0) {
				res.add(0, curLevel);
				numCur = numNext;
				numNext = 0;
				curLevel = nextLevel;
				nextLevel = new ArrayList<Integer>();
			}

		}

		return res;

	}

}
