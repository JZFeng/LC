/*
 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/#/description
 103. Binary Tree Zigzag Level Order Traversal
 
 Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
  
 */
package jz.lc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jz.tree.bst.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.fromString("3,9,20,#,#,15,7");

		List<List<Integer>> res = zigzagLevelOrder(root);
		for (List<Integer> a : res) {
			Iterator<Integer> itr = a.iterator();
			while (itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}

	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> res = new LinkedList<List<Integer>>();

		if (root == null)
			return res;

		TreeNode cur = root;
		// int numofLevels = 0;
		boolean isOddLevel = true;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> curLevel = new LinkedList<Integer>();
		List<Integer> nextLevel = new LinkedList<Integer>();
		int numCur = 1;
		int numNext = 0;
		queue.offer(cur);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			if (isOddLevel) {
				curLevel.add(tmp.val);
			} else {
				curLevel.add(0, tmp.val);
			}
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
				res.add(curLevel);
				numCur = numNext;
				numNext = 0;
				curLevel = nextLevel;
				nextLevel = new LinkedList<Integer>();
				isOddLevel = !isOddLevel;
			}

		}

		return res;

	}

}
