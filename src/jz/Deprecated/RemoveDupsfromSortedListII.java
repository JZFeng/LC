/**
 https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/#/description
 
 82. Remove Duplicates from Sorted List II
 
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 *
 */
package jz.Deprecated;

import jz.LinkedList.ListNode;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveDupsfromSortedListII {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[] { 1, 2, 3, 3 });
		ListNode.printList(deleteDuplicates(head));

	}

	// User three pointers, pre, cur,nxt;
	public static ListNode deleteDuplicatesII(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		int count = 1;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur = cur.next;
				count++;
			} else if (count > 1) {
				pre.next = cur.next;
				cur = cur.next;
				count = 1;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}

		if (count > 1) {
			pre.next = null;
		}

		return dummy.next;

	}

	// User a counter. If counter > 1, remove all of them. If counter = 1, keep
	// moving.
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		int count = 1;
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val != cur.next.val) {
				if (count == 1) {
					pre = cur;
					cur = cur.next;
				} else {
					pre.next = cur.next;
					cur = cur.next;
					count = 1;
				}
			} else {
				count++;
				cur = cur.next;

			}
		}

		if (count > 1) {
			pre.next = null;
		}

		return dummy.next;
	}

}
