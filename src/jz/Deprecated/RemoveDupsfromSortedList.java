/**
 https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
 
 83. Remove Duplicates from Sorted List
 
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 
 */
package jz.Deprecated;

import jz.LinkedList.ListNode;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveDupsfromSortedList {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[] { 1, 1, 2, 2, 2, 3, 3, 3, 3 });
		ListNode.printList(deleteDuplicates(head));

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return head;

	}
}
