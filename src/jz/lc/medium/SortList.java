/*
https://leetcode.com/problems/sort-list/#/description

148. Sort List

Sort a linked list in O(n log n) time using constant space complexity.

 */
package jz.lc.medium;

import jz.LinkedList.ListNode;

public class SortList {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[] { 7, 6, 5, 4, 3, 2, 1 });
		ListNode.printList(head);
		ListNode.printList(sortList(head));

	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// divide the list into two halves
		ListNode pre = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		pre.next = null;

		// Sort two separate lists
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// merge two sorted list.
		return merge(l1, l2);

	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = l1;
		ListNode pre1 = dummy;
		ListNode cur1 = l1;

		ListNode cur2 = l2;

		while (cur1 != null && cur2 != null) {
			if (cur1.val >= cur2.val) {
				ListNode tmp = cur2.next;
				pre1.next = cur2;
				cur2.next = cur1;

				cur1 = cur2;
				cur2 = tmp;
			} else {
				pre1 = cur1;
				cur1 = cur1.next;
			}
		}

		if (cur1 == null && cur2 != null) {
			pre1.next = cur2;
		}

		return dummy.next;
	}

}
