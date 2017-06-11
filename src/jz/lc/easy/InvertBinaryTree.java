/*
 https://leetcode.com/problems/invert-binary-tree/#/description
 226. Invert Binary Tree
 
  Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), 
but you can’t invert a binary tree on a whiteboard so fuck off.
 */
package jz.lc.easy;

import jz.tree.bst.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		TreeNode root = TreeNode.fromString("4,2,7,1,3,6,9");
		System.out.println(TreeNode.toString(root));
		System.out.println(TreeNode.toString(invertTree(root)));

	}
	
	public static TreeNode invertTree(TreeNode root) {
		if(root == null){
			return null;
		}
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		
		return root;
		
	}

}
