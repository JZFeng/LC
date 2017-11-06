/**
https://leetcode.com/problems/merge-two-sorted-lists/#/description

21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

 *
 */
package jz.Deprecated;

import jz.LinkedList.ListNode;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = ListNode.listfromArray(new int[] { 5 });
		ListNode l2 = ListNode.listfromArray(new int[] { 1, 2, 4 });
		ListNode.printList(mergeTwoLists(l1, l2));

	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		ListNode dummy = new ListNode(0);
		dummy.next = l1;
		ListNode pre = dummy;
		ListNode cur1 = l1;
		ListNode cur2 = l2;

		while (cur1 != null && cur2 != null) {
			if (cur2.val <= cur1.val) {
				ListNode tmp = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				cur1 = cur2;
				cur2 = tmp;
			} else {
				pre = cur1;
				cur1 = cur1.next;
			}

		}

		if (cur2 != null)
			pre.next = cur2;

		return dummy.next;

	}
}
