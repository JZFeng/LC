/*
 https://leetcode.com/problems/rotate-list/#/description
 
 61. Rotate List

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

 */
package jz.lc;

import jz.LinkedList.ListNode;

public class RotateList {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[] { 1, 2 });
		ListNode.printList(head);

		ListNode.printList(rotateRight(head, 2));

	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return null;
		}

		k = k % getLength(head);

		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		ListNode slow = head;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;

		return newHead;

	}

	private static int getLength(ListNode head) {
		if (head == null) {
			return 0;
		}

		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}

		return length;
	}
}
