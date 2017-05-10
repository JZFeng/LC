/**
https://leetcode.com/problems/add-two-numbers/#/description

You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 *
 */
package jz.lc;
import jz.LinkedList.ListNode;

public class AddTwoNumbers
{

    public static void main(String[] args)
    {
        

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int size1 = ListNode.size(l1);
        int size2 = ListNode.size(l2);
        ListNode longer = (size1 >= size2) ? l1 : l2;
        ListNode res = longer;
        ListNode shorter = (longer == l1) ? l2 : l1;
        boolean isUp = false;

        while (shorter != null)
        {
            longer.val = shorter.val + longer.val;
            if (isUp)
            {
                longer.val++;
            }

            if (longer.val >= 10)
            {
                isUp = true;
                longer.val = longer.val % 10;
            }
            shorter = shorter.next;
            longer = longer.next;
        }

        while (longer != null && longer.next != null)
        {
            if (isUp)
                longer.val++;

            if (longer.val >= 10)
            {
                longer.val = longer.val % 10;
                isUp = true;
                longer = longer.next;
            }
            else
            {
                return res;
            }
        }

        if (longer != null)
        {
            if (isUp)
                longer.val++;
            if (longer.val >= 10)
            {
                longer.val = longer.val % 10;
                longer.next = new ListNode(1);
            }

        }

        return res;
    }

}
