/*
 https://leetcode.com/problems/linked-list-cycle/#/description
 
 141. Linked List Cycle Add to List
  
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 
 */
package jz.lc;

import jz.LinkedList.ListNode;

public class LinkedListCycle
{

    public static void main(String[] args)
    {
        //create a list with cycle.
        ListNode l1 = ListNode.listfromArray(new int[]{ 1, 2, 3, 4 });
        ListNode cur = l1;
        ListNode node2 = null;
        ListNode node4 = null;
        while (cur!=null)
        {
            if(cur.val == 2)
                node2 = cur;
            else if(cur.val == 4)
                node4 = cur;
            
            cur = cur.next;
        }
        node4.next = node2;
        
        System.out.println(hasCycle(l1));
        
        ListNode l2 = ListNode.listfromArray(new int[]{1,2,3,4,5});
        System.out.println(hasCycle(l2));
        
        ListNode l3 = new ListNode(1);
        l3.next = l3;
        System.out.println(hasCycle(l3));

    }

	public static boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true;
        }

        return false;

    }

}
