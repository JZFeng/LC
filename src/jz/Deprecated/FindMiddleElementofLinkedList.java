/*
 Given a singly linked list
 find middle of the linked list.

 */
package jz.Deprecated;

import jz.LinkedList.ListNode;

public class FindMiddleElementofLinkedList
{

    public static void main(String[] args)
    {
        ListNode head = ListNode.listfromArray(new int[]{1,2,3,4});
        System.out.println(findMiddle(head).val );
        System.out.println(findMid(head).val);
    }
    
    public static ListNode findMiddle(ListNode head)
	{
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

    public static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    
    }
}
