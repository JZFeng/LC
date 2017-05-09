package jz.LinkedList;

public class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x)
	{
		this.val = x;
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
		ListNode head = listfromArray(new int[]{});
		printList(head);
	}

}
