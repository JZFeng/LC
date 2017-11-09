package jz.LadderOnly;
import jz.tree.bst.TreeNode;

//http://lintcode.com/en/problem/binary-tree-longest-consecutive-sequence/
public class BinaryTreeLongestConsecutiveSequence {
	
	private int global_longest = Integer.MIN_VALUE;
	
    public int longestConsecutive(TreeNode root) {
    	helper(root);
    	return global_longest;
    }
    
    //返回此子树的最长序列；
    private int helper(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
    	int left = helper(root.left);
    	int right = helper(root.right);
    	
    	int subtree_longest = 1;
    	if(root.left != null && root.val + 1 == root.left.val) {
    		subtree_longest = Math.max(subtree_longest, left + 1);
    	}
    	if(root.right != null && root.val + 1 == root.right.val) {
    		subtree_longest = Math.max(subtree_longest, right + 1);
    	}
    	
    	global_longest = Math.max(global_longest, subtree_longest); //更新全局最长序列；
    	
    	return subtree_longest;
    	
    }
}
