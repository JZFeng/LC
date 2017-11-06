/*
 https://leetcode.com/problems/palindrome-linked-list/#/description
 
 234. Palindrome Linked List
 
 Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
  
 */
package jz.Deprecated;

import jz.LinkedList.ListNode;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[] { 1, 2, 2, 3, 1 });
		System.out.println(isPalindrome(head));

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;

		// find the middle one
		ListNode middle = findMiddle(head);

		// reverse from the middle, middleHead is the new head;
		ListNode middleHead = reverseList(middle);

		ListNode cur1 = head;
		ListNode cur2 = middleHead;
		while (cur1 != null && cur2 != null) {
			if (cur1.val != cur2.val)
				return false;
			else {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
		}

		return true;

	}

	private static ListNode reverseList(ListNode slow) {
		ListNode pre = null;
		ListNode cur = slow;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	private static ListNode findMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

}
