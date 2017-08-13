/**
https://leetcode.com/problems/remove-nth-node-from-end-of-list/#/description

19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.

 */

package jz.lc.medium;

import jz.LinkedList.ListNode;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveNthFromEndofList {

	public static void main(String[] args) {

		ListNode head = ListNode.listfromArray(new int[] { 1, 2, 3, 4, 5 });
		ListNode.printList(head);
		ListNode.printList(removeNthFromEnd(head, 2));

	}

	public static ListNode removeNthFromEnd(ListNode head, int k) {
		if (head == null)
			return null;

		int size = ListNode.size(head);
		int count = 1;
		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;

		while (count < size - k + 1) {
			pre = cur;
			cur = cur.next;
			count++;
		}

		pre.next = cur.next;

		return dummy.next;
	}

}
