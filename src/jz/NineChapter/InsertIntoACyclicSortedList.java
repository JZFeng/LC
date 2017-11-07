package jz.NineChapter;

import jz.LinkedList.ListNode;

public class InsertIntoACyclicSortedList {

	/*
	 * @param node: a list node in the list
	 * 
	 * @param x: An integer
	 * 
	 * @return: the inserted new list node
	 */
	public ListNode insert(ListNode node, int x) {
		// write your code here
		ListNode newNode = new ListNode(x);
		if (node == null) {

			newNode.next = newNode;
			return newNode;
		}
		ListNode p = node;
		ListNode prev = null;
		do {
			prev = p;
			p = p.next;
			if (x <= p.val && x > prev.val) {
				break;
			}
			if (prev.val > p.val && (x >= prev.val || x <= p.val)) {
				break;
			}
		} while (p != node);
		newNode.next = p;
		prev.next = newNode;
		return newNode;
	}

}
