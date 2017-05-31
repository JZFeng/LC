/**
 https://leetcode.com/problems/remove-duplicates-from-sorted-list/#/description
 
 83. Remove Duplicates from Sorted List
 
 Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 
 */
package jz.lc.easy;

import jz.LinkedList.ListNode;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveDupsfromSortedList
{

    public static void main(String[] args)
    {
        ListNode head = ListNode.listfromArray(new int[]
        { 1, 2, 3 });
        ListNode.printList(deleteDuplicates(head));

    }

    public static ListNode deleteDuplicates(ListNode head)
    {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null)
        {
            if (cur.val == cur.next.val)
            {
                pre.next = cur.next;
                cur = cur.next;
            }
            else
            {
                pre = cur;
                cur = cur.next;
            }

        }
        return dummy.next;

    }

}
