/**
 https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
 
 102. Binary Tree Level Order Traversal
 
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 
 
 */
package jz.lc.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jz.tree.bst.BinarySearchTree;
import jz.tree.bst.TreeNode;

/**
 *@author jzhfeng
 *@date May 13, 2017
*/
public class BinaryTreeLevelOrderTraversal
{

    public static void main(String[] args)
    {
        TreeNode root = TreeNode.fromString("1,3,2,5,4,7,6");
        
        List<Integer> res = levelOrder(root);
        System.out.println(res);
        
    }
    

    public static List<Integer> levelOrder(TreeNode root) {
    	List<Integer> res = new LinkedList<>();
    	if ( root == null) {
    		return res;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	while ( !queue.isEmpty() ) {
    		TreeNode tmp = queue.poll();
    		res.add(tmp.val);
    		if (tmp.left != null) {
    			queue.offer(tmp.left);
    		}
    		if (tmp.right != null) {
    			queue.offer(tmp.right);
    		}
    	}
    	
    	return res;
    }

}
