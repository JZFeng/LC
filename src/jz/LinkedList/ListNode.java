package jz.LinkedList;

public class ListNode {
	public int val;
	public ListNode next;
	
	public ListNode(int x)
	{
		this.val = x;
	}
	
	public static int size(ListNode head)
	{
		if(head == null)
			return 0;
		
		int size = 0;
		while(head != null)
		{
			size++;
			head = head.next;
		}
		
		return size;
	}
	
	public static ListNode listfromArray(int[] a)
	{
		if(a==null || a.length == 0)
			return null;
		
		ListNode head = new ListNode(a[0]);
		ListNode current = head;
		for (int i = 1; i < a.length; i++) {
			ListNode tmp = new ListNode(a[i]);
			current.next = tmp;
			current = tmp;
		}
		
		return head;
	}
	
	public static void printList(ListNode head)
	{
		if(head == null)
			System.out.println("Empty List");
		
		ListNode current = head;
		while(current != null)
		{
			System.out.print(current.val +" ");
			current = current.next;
		}
		System.out.println();
	}
	
	
	public static void main(String[] args)
	{
		ListNode head = listfromArray(new int[]{1,2,3});
		System.out.println(size(head));
		printList(head);
	}

}
