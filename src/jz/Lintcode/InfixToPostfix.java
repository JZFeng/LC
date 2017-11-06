package jz.Lintcode;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {

	}

	/*
	 * 1.3.10 Write a filter InfixToPostfix that converts an arithmetic
	 * expression from infix to postfix.
	 * 
	 */

	public static String inFixtoPostFix(String input) {
		String s = "";
		StringBuilder sb = new StringBuilder();
		Stack<String> ops = new Stack<String>();

		for (int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			if (tmp == '(') {
				ops.push(String.valueOf(tmp));
			} else if (tmp == ')') {
				if (s.trim().length() > 0) {
					sb.append(s.trim() + " ");
					s = "";
				}

				while (!ops.peek().equalsIgnoreCase("(")) {
					sb.append(ops.pop() + " ");
				}
				ops.pop();

			} else if (isOperator(tmp)) {
				if (s.trim().length() > 0) {
					sb.append(s.trim() + " ");
					s = "";
				}

				int p = priorityCal(String.valueOf(tmp));

				if (ops.isEmpty())
					ops.push(String.valueOf(tmp));
				else if (p > priorityCal(ops.peek()))
					ops.push(String.valueOf(tmp));
				else {
					while (!ops.isEmpty() && p <= priorityCal(ops.peek())) {
						sb.append(ops.pop() + " ");
					}
					ops.push(String.valueOf(tmp));
				}

			} else {
				s = s + tmp;
			}

		}

		sb.append(s.trim());

		while (!ops.isEmpty()) {
			sb.append(ops.pop());
		}

		return sb.toString().trim();
	}

	private static int priorityCal(String s) {
		if (s.equalsIgnoreCase("*") || s.equalsIgnoreCase("/"))
			return 1;
		else if (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-"))
			return 0;
		else
			return -1;
	}
	
	private static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}
}
