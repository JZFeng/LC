/*
 https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 
 160. Intersection of Two Linked Lists
 
 Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 
 */
package jz.lc;

import jz.LinkedList.ListNode;

public class IntersectionofTwoLinkedLists {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null && headB == null)
			return null;
		int lenA = len(headA);
		int lenB = len(headB);
		int diff = Math.abs(lenA - lenB);
		if (lenA > lenB) {
			while (diff != 0) {
				headA = headA.next;
				diff--;
			}
		} else {
			while (diff != 0) {
				headB = headB.next;
				diff--;
			}
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}

		return headA;
	}

	private static int len(ListNode head) {
		if (head == null)
			return 0;
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
