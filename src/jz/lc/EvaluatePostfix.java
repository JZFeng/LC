package jz.lc;

import java.util.Stack;

public class EvaluatePostfix {

	public static void main(String[] args) {

	}
	
	/*
	 1.3.11 Write a program EvaluatePostfix that takes a postfix expression from standard
    input, evaluates it, and prints the value. (Piping the output of your program from
    the previous exercise to this program gives equivalent behavior to Evaluate. 
	 */
	public static double evaluatePostFix(String input) { // 4 8 + 6 5 - * 3 2 -
															// 2 2 + * /
		if (input == null || input.length() == 0)
			return Double.MIN_VALUE;

		Stack<Double> operands = new Stack<Double>();
		String[] tmp = input.split(" ");
		for (int i = 0; i < tmp.length; i++) {
			String s = tmp[i];
			if (!isOperator(s))
				operands.push(Double.parseDouble(s));
			else {
				Double val;

				if (s.equalsIgnoreCase("+")) {
					val = operands.pop();
					operands.push(operands.pop() + val);
				} else if (s.equalsIgnoreCase("-")) {
					val = operands.pop();
					operands.push(operands.pop() - val);
				} else if (s.equalsIgnoreCase("*")) {
					val = operands.pop();
					operands.push(operands.pop() * val);
				} else if (s.equalsIgnoreCase("/")) {
					val = operands.pop();
					operands.push(operands.pop() / val);
				}

			}

		}

		return operands.pop().doubleValue();
	}

	private static boolean isOperator(String s) {
		return (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-") || s.equalsIgnoreCase("*")
				|| s.equalsIgnoreCase("/"));
	}


}
