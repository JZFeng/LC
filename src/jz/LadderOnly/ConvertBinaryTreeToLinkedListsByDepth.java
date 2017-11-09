package jz.LadderOnly;
//http://lintcode.com/en/problem/convert-binary-tree-to-linked-lists-by-depth/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import jz.LinkedList.ListNode;
import jz.tree.bst.TreeNode;

public class ConvertBinaryTreeToLinkedListsByDepth {
	
	public class Solution {
		/**
		 * @param root
		 *            the root of binary tree
		 * @return a lists of linked list
		 */
		public List<ListNode> binaryTreeToLists(TreeNode root) {
			// Write your code here
			List<ListNode> result = new ArrayList<ListNode>();
			if (root == null) {
				return result;
			}
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				ListNode dummyP = new ListNode(0);
				ListNode p = dummyP;
				int qSize = queue.size();
				for (int i = 0; i < qSize; i++) {
					TreeNode temp = queue.poll();
					ListNode tempListNode = new ListNode(temp.val);
					p.next = tempListNode;
					p = p.next;
					if (temp.left != null) {
						queue.offer(temp.left);
					}
					if (temp.right != null) {
						queue.offer(temp.right);
					}
				}
				result.add(dummyP.next);
			}
			return result;
		}
	}
}
