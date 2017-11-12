/**
https://leetcode.com/problems/maximum-depth-of-binary-tree/#/description

104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path 
from the root node down to the farthest leaf node.

 */
package jz.Deprecated;

import jz.tree.bst.TreeNode;

/**
 *@author jzhfeng
 *@date May 12, 2017
 */
public class MaximumDepthofBinaryTree
{

    public static void main(String[] args)
    {
        String s = "3,5,7,#,2,1";
        TreeNode root = TreeNode.fromString(s);
        System.out.println(TreeNode.toString(root));
        System.out.print(s);

    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    

}
