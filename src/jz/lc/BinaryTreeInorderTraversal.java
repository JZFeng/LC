/*
 https://leetcode.com/problems/binary-tree-inorder-traversal/#/description
 
 94. Binary Tree Inorder Traversal
 
 Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


  
 */
package jz.lc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import jz.LinkedList.ListNode;
import jz.tree.bst.BinarySearchTree;
import jz.tree.bst.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = TreeNode.fromString("1,2,3,4,5,6,7");
		BinarySearchTree bst = new BinarySearchTree(root);
		bst.inOrder();
		System.out.println();

		ArrayList<Integer> arraylist = (ArrayList<Integer>) inorderTraversal(root);
		Iterator<Integer> itr = arraylist.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			// save all left nodes;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			// 处理中间节点
			cur = stack.pop();
			res.add(cur.val);
			// 处理右节点
			cur = cur.right;
		}
		return res;
	}

}
