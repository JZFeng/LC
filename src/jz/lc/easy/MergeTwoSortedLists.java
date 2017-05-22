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
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = l1;
        ListNode pre1 = dummy;
        ListNode cur1 = l1;
        
        ListNode cur2 = l2;
        
        while(cur1 != null && cur2 != null)
        {
            if(cur1.val >= cur2.val) 
            {
                ListNode tmp = cur2.next;
                pre1.next = cur2;
                cur2.next = cur1;
                
                cur1 = cur2;
                cur2 = tmp;
            }
            else
            {
                pre1 = cur1;
                cur1 = cur1.next;
            }
        }
        
        if(cur1 == null && cur2 != null)
        {
            pre1.next = cur2;
        }
        
        return dummy.next;
    }
    
    
 

}
