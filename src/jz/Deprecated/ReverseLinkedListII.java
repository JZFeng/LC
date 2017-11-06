package jz.Deprecated;

import jz.LinkedList.ListNode;

/**
 https://leetcode.com/problems/reverse-linked-list-ii/#/description

 92. Reverse Linked List II

 Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example:
 Given 1->2->3->4->5->NULL, m = 2 and n = 4,

 return 1->4->3->2->5->NULL.

 Note:
 Given m, n satisfy the following condition:
 1 <= m <= n <= length of list.

 */

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[] { 1, 2, 3, 4, 5 });
		ListNode.printList(head);
		ListNode.printList(reverseBetween(head, 2, 4));

	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null)
			return null;

		int i = 1;

		ListNode dummy = new ListNode(Integer.MAX_VALUE);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode cur = head;
		while (i < m) {
			pre = cur;
			cur = cur.next;
			i++;
		}

		ListNode a = pre;
		ListNode b = cur;

		while (i <= n) {
			ListNode nxt = cur.next;
			cur.next = pre;

			pre = cur;
			cur = nxt;
			i++;
		}

		a.next = pre;
		b.next = cur;

		return dummy.next;

	}

}
