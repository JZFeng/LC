package jz.LinkedList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



public class LinkedListSolution
{
    public static void main(String[] args) throws IOException
    {
        ListNode head = ListNode.listfromArray(new int[]
        { 1, 2, 5, 8, 10 });
        ListNode.printList(head);
        System.out.println((find(head, 0)));
    }

    
    
    
    public static ListNode removeAfter(ListNode node)
    {
        if(node == null || node.next == null)
            return node;
        
        node.next = node.next.next;
        
        return node;
        
    }
    
    public static boolean find(ListNode head, int n)
    {
        if(head == null )
            return false;
        ListNode cur = head;
        while(cur != null)
        {
            if(cur.val == n)
                return true;
            else
                cur = cur.next;
        }
        
        return false;
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int k)
    {
        if (head == null)
            return null;
        
        if(k<1)
            return null;

        int size = 0;
        ListNode tmp = head;
        while (tmp != null)
        {
            size++;
            tmp = tmp.next;
        }

            
        if (size < k)
            return null;

        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode nxt = cur.next;

        int count = 0;

        while (count != size - k )
        {
            pre = cur;
            cur = cur.next;
            nxt = cur.next;
            count++;
        }

        pre.next = nxt;

        return dummy.next;

    }

    public static ListNode removeLastNode(ListNode head)
    {

        if (head == null)
            return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null)
        {
            pre = cur;
            cur = cur.next;
        }

        pre.next = null;
        return dummy.next;
    }

    public static ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null)
        {
            ListNode nxt = cur.next;
            cur.next = pre;

            pre = cur;
            cur = nxt;
        }

        return pre;

    }

    public static ListNode deleteDuplicatesII(ListNode head)
    {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode first = dummy;

        while (cur != null && cur.next != null)
        {
            // unique node is cur;
            if (pre.val != cur.val && cur.val != cur.next.val)
            {
                first.next = cur;
                first = cur;
            }

            pre = cur;
            cur = cur.next;

        }

        if (pre.val != cur.val)
        {
            first.next = cur;
            first = cur;
        }

        first.next = null;

        return dummy.next;

    }

    public static ListNode deleteDuplicatesII2(ListNode head)
    {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null)
        {
            // unique node in the list is cur.next;
            while (cur.next != null && cur.val == cur.next.val)
            {
                cur = cur.next;
            }

            if (pre.next == cur)
            {
                pre = pre.next;
            }
            else
            {
                pre.next = cur.next;
            }

            cur = cur.next;

        }

        return dummy.next;

    }

    public static ListNode removeDuplicates(ListNode head)
    {

        if (head == null)
            return null;

        ListNode current = head;

        while (current.next != null)
        {
            ListNode tmp = current.next;
            if (current.val == tmp.val)
            {
                current.next = tmp.next;
            }
            else
            {
                current = current.next;
            }

        }

        return head;
    }

}
