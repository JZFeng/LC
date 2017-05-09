package jz.DoubleLinkedList;

import java.util.Iterator;

public class TestDllist {
	public static void main(String[] args) {
		Object[] a = { 9, 7, 5, 3, 1 };
		DoubleLinkedList dl = new DoubleLinkedList(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(dl.getNodeAtIndex(i).getData()+" ");
		}

		System.out.println();
		
//		dl.clear();
		
		if(!dl.isEmpty())
		{
			Iterator<Integer> itr = dl.iterator();
			
			while (itr.hasNext()) {
				Integer tmp = (Integer) itr.next();
				System.out.print(tmp + " ");
				if (tmp.equals(new Integer(3)))
					itr.remove();
			}
			
		}
		
			

		System.out.println();

		if(!dl.isEmpty())
		{
			ListNode current = dl.head.next;
			while (current != dl.head) {
				System.out.print(current.element + " ");
				current = current.next;
				
			}
		}

	}

	public static void print(DoubleLinkedList dl) {
		if (dl.size() == 0)
			System.out.println("Empty");

		ListNode p = dl.head.next;
		while (p != dl.head) {
			System.out.print(p.element + " ");
			p = p.next;
		}

	}
}