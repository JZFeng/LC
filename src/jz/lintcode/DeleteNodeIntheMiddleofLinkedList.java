package jz.lintcode;

import jz.LinkedList.ListNode;

public class DeleteNodeIntheMiddleofLinkedList {

	public static void main(String[] args) {
		ListNode head = ListNode.listfromArray(new int[]{1,2});
		ListNode.printList(head);
		ListNode.printList(deleteMiddle(head));

	}
	
	private static ListNode deleteMiddle(ListNode head ) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode pre = dummy;
		ListNode fast = head;
		ListNode slow = head;
		while ( fast != null && fast.next != null) {
			fast = fast.next.next;
			pre = slow;
			slow = slow.next;
		}
		pre.next = slow.next;
		
		return dummy.next;
	}
	
}
