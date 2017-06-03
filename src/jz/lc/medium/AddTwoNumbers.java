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
package jz.lc.medium;

import jz.LinkedList.ListNode;

public class AddTwoNumbers
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;

        ListNode dummy1 = new ListNode(0);
        dummy1.next = l1;
        ListNode pre1 = dummy1;
        ListNode cur1 = l1;

        ListNode dummy2 = new ListNode(0);
        dummy2.next = l2;
        ListNode pre2 = dummy2;
        ListNode cur2 = l2;

        boolean hasCarry = false;

        // store result into l2
        while (cur1 != null && cur2 != null)
        {
            if (hasCarry)
            {
                cur2.val++;
                hasCarry = false;
            }
            if ((cur1.val + cur2.val) >= 10)
            {
                cur2.val = (cur1.val + cur2.val) % 10;
                hasCarry = true;
            }
            else
                cur2.val = cur1.val + cur2.val;

            pre1 = cur1;
            cur1 = cur1.next;
            pre2 = cur2;
            cur2 = cur2.next;
        }

        if (cur2 == null && cur1 == null)
        {
            if (hasCarry)
                pre2.next = new ListNode(1);
        }
        else if (cur2 != null && hasCarry)
        {
            while (cur2 != null)
            {
                if(++cur2.val <10)
                    return dummy2.next;
                else{
                    cur2.val = cur2.val%10;
                    hasCarry = true;
                    pre2 = cur2;
                    cur2 = cur2.next;
                }
            }
            if (hasCarry)
                pre2.next = new ListNode(1);
        }
        else if(cur2!=null && !hasCarry)
            return dummy2.next;
        else    
        {
            pre2.next = cur1;
            if(hasCarry)
            {
                while(cur1 != null){
                    if(++cur1.val <10)
                        return dummy2.next;
                    else{
                        cur1.val = cur1.val%10;
                        hasCarry = true;
                        pre1 = cur1;
                        cur1 = cur1.next;
                    }
                }
                if (hasCarry)
                    pre1.next = new ListNode(1);
            }
        }

        return dummy2.next;

    }

}
