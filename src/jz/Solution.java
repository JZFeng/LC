package jz;

import java.io.*;
import java.util.*;

import jz.LinkedList.ListNode;

/**
 * Definition for ListNode public class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode head = ListNode.listfromArray(new int[]{1,2,3,4,5});
		ListNode tmp = s.reverseBetween(head, 2, 4);
		System.nanoTime();
		
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;

		// preM和M
		for (int i = 1; i < m; i++) {
			pre = cur;
			cur = cur.next;
		}
		ListNode preM = pre;
		ListNode M = cur;

		for (int i = m; i <= n; i++) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}

		preM.next = pre;
		M.next = cur;

		return dummy.next;

	}
}