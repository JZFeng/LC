/**
 https://leetcode.com/problems/reverse-linked-list/#/description
 
 206. Reverse Linked List
 
 Reverse a singly linked list.
 
 */
package jz.lc.easy;

import jz.LinkedList.ListNode;

/**
 *@author jzhfeng
 *@date May 13, 2017
*/
public class ReverseLinkedList
{

    public static void main(String[] args)
    {
        ListNode head = ListNode.listfromArray(new int[]{1,2,3,4,5});
        ListNode.printList(head);
        ListNode.printList(reverseListRecursive(head));

    }
    
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode pre = null;
        ListNode cur = head;
        
        while(cur != null)
        {
            ListNode nxt = cur.next;
            cur.next = pre;
            
            pre = cur;
            cur = nxt;
        }
        
        return pre;
    }
    
    public static ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode nxt = head.next;
        
        ListNode newHead = reverseListRecursive(head.next);
        
        head.next = null;
        nxt.next = head;
        
        return newHead;
        
    }
}
