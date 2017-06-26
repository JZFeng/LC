package jz.LinkedList;

public class ListNode
{
    public int val;

    public ListNode next;

    public ListNode(int x)
    {
        this.val = x;
    }

    public static int size(ListNode head)
    {
        if (head == null)
            return 0;

        int size = 0;
        while (head != null)
        {
            size++;
            head = head.next;
        }

        return size;
    }

    public static ListNode listfromArray(int[] a)
    {
        if (a == null || a.length == 0)
            return null;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode pre = dummy;
        for(int i = 0 ; i <a.length ; i++) {
        	ListNode cur = new ListNode(a[i]);
        	pre.next = cur;
        	pre = cur;
        }
        
        return dummy.next;
    }

    public static void printList(ListNode head)
    {
        if (head == null)
            System.out.println("Empty List");

        ListNode current = head;
        while (current != null)
        {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static ListNode findMiddle(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args)
    {
        ListNode head = listfromArray(new int[]
        {1,2});
        printList(head);
    }

}
