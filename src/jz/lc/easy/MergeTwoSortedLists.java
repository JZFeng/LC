/**
https://leetcode.com/problems/merge-two-sorted-lists/#/description

21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.

 *
 */
package jz.lc.easy;

import jz.LinkedList.ListNode;

/**
 *@author jzhfeng
 *@date May 10, 2017
 */
public class MergeTwoSortedLists
{

    public static void main(String[] args)
    {
        ListNode l1 = ListNode.listfromArray(new int[]{1,3,3,4,5});
        ListNode l2 = ListNode.listfromArray(new int[]{2,3,4});
       
        ListNode.printList(mergeTwoLists(l1,l2));
        ListNode.printList(l1);
        
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = l1;
        ListNode pre = dummy;
        ListNode cur1 = l1;
        
        while(l2 != null && cur1 != null)
        {
            if(l2.val <= cur1.val)
            {
                ListNode tmp = l2.next;
                pre.next = l2;
                l2.next = cur1;
  
                pre = l2;
                l2 = tmp;
            }
            else
            {
                pre = cur1;
                cur1 = cur1.next;
            }
        }
        
        if(cur1 == null && l2 != null)
        {
            pre.next = l2;
        }
        
        return dummy.next;
        
    }
    
    
    private static ListNode insertNode(ListNode head, int n)
    {
        ListNode node = new ListNode(n);
        if(node == null)
            return head;
        
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = head;
        
        while(cur != null)
        {
            if(node.val <= cur.val)
            {
                pre.next = node;
                node.next = cur;
                return dummy.next;
                
            }
            else
            {
                pre = cur;
                cur = cur.next;
            }
        }
        
        if(cur == null)
        {
            pre.next = node;
        }
        
        
        return dummy.next;
    }
   

}
