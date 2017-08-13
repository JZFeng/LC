package jz.lc.easy;

import java.util.Stack;

/*
  https://leetcode.com/problems/min-stack/#/description
  
  155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
   
 */

public class MinStack {

	public static void main(String[] args) {
		int tmp = 0;
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // --> Returns -3.
		minStack.pop();
		System.out.println(tmp = minStack.top()); // --> Returns 0.
		System.out.println(minStack.getMin()); // --> Returns -2.

	}

	Stack<Integer> stack1 = null;
	Stack<Integer> stack2 = null;

	/** initialize your data structure here. */
	public MinStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int x) {
		stack1.push(x);
		if (stack2.isEmpty())
			stack2.push(x);
		else if (stack2.peek() >= x)
			stack2.push(x);
	}

	public void pop() {
		int tmp = stack1.pop();
		if (tmp == stack2.peek())
			stack2.pop();
	}

	public int top() {
		return stack1.peek();
	}

	public int getMin() {
		return stack2.peek();
	}

}
