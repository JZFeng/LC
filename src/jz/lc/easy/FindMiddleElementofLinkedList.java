/*
 Given a singly linked list
 find middle of the linked list.

 */
package jz.lc.easy;

import jz.LinkedList.ListNode;

public class FindMiddleElementofLinkedList
{

    public static void main(String[] args)
    {
        ListNode head = ListNode.listfromArray(new int[]{1,2,3,4,5});
        System.out.println(findMiddle(head).val);

    }
    
    public static ListNode findMiddle(ListNode head)
    {
        if(head == null || head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

}
