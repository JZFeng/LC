/*
https://leetcode.com/problems/sort-list/#/description

148. Sort List

Sort a linked list in O(n log n) time using constant space complexity.

 */
package jz.lc.medium;

import jz.LinkedList.ListNode;

public class SortList
{

    public static void main(String[] args)
    {

    }

    public ListNode sortList(ListNode head)
    {
        if(head == null || head.next == null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
        }
        
        return null;

    }
    
   

}
