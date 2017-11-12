package jz.LadderOnly.Unresolved;

//http://lintcode.com/en/problem/convert-binary-search-tree-to-doubly-linked-list/
public class ConvertBinarySearchTreeToDoublyLinkedList {

	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public class DoublyListNode {
		int val;
		DoublyListNode next, prev;

		DoublyListNode(int val) {
			this.val = val;
			this.next = this.prev = null;
		}
	}

	public DoublyListNode bstToDoublyList(TreeNode root) {
		return null;
	}

}
