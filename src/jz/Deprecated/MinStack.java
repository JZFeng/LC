package jz.Deprecated;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack = null;
	private Stack<Integer> minstack = null;

	public MinStack() {
		stack = new Stack<Integer>();
		minstack = new Stack<Integer>();
	}

	public void push(int number) {
		stack.push(number);
		if (minstack.isEmpty() || minstack.peek() >= number) { // >= NOT >
			minstack.push(number);
		}
	}

	public int pop() {
		int num = stack.pop();
		if (!minstack.isEmpty() && num == minstack.peek()) {
			minstack.pop();
		}

		return num;
	}

	public int min() {
		return minstack.peek();
	}
}