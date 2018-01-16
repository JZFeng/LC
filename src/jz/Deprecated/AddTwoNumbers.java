/**
https://leetcode.com/problems/add-two-numbers/#/description

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 *
 */
package jz.Deprecated;

import jz.LinkedList.ListNode;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//JZ modified this document in the upstream
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int tmp = carry + l1.val + l2.val;
			pre.next = new ListNode(tmp % 10);
			carry = tmp / 10;
			l1 = l1.next;
			l2 = l2.next;
			pre = pre.next;
		}

		while (l1 != null) {
			int tmp = carry + l1.val;
			pre.next = new ListNode(tmp % 10);
			carry = tmp / 10;
			pre = pre.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			int tmp = carry + l2.val;
			pre.next = new ListNode(tmp % 10);
			carry = tmp / 10;
			pre = pre.next;
			l2 = l2.next;
		}

		if (carry != 0) {
			pre.next = new ListNode(carry);
		}

		return dummy.next;

	}

}
