package jz.DoubleLinkedList;

public class ListNode {

	ListNode prev;
	Object element;
	ListNode next;

	public ListNode(ListNode prior, Object data, ListNode next) {
		this.prev = prior;
		this.element = data;
		this.next = next;
	}

	public ListNode() {
		this(null, null, null);
	}

	public Object getData() {
		return element;
	}

	public void setData(Object data) {
		this.element = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public ListNode getPrior() {
		return prev;
	}

	public void setPrior(ListNode prior) {
		this.prev = prior;
	}

}
