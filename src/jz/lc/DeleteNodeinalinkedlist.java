/**
 https://leetcode.com/problems/delete-node-in-a-linked-list/#/description
 
 237. Delete Node in a Linked List
 
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
the linked list should become 1 -> 2 -> 4 after calling your function.
 
 */
package jz.lc;

import java.util.HashSet;
import java.util.Set;

import jz.LinkedList.ListNode;

/**
 * @author jzhfeng
 * @date May 14, 2017
 */
public class DeleteNodeinalinkedlist
{

    public static void main(String[] args)
    {
        ListNode head = ListNode.listfromArray(new int[]{1,2,3,4});
        ListNode.printList(head);
        ListNode cur = head;
        while(cur.val != 3)
            cur = cur.next;
        deleteNode(cur);
        ListNode.printList(head);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
   
}
