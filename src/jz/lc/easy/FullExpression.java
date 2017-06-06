package jz.lc.easy;

import java.util.Stack;

public class FullExpression {

	public static void main(String[] args) {

	}
	
	/*
	1.3.9 Write a program that takes from standard input an expression without left parentheses
	and prints the equivalent infix expression with the parentheses inserted. For
	example, given the input:
	1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
	your program should print
	( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) 

	*/
		public static String fullExpression(String input) {
			String s = "";
			Stack<String> nums = new Stack<String>();
			Stack<String> ops = new Stack<String>();
			for (int i = 0; i < input.length(); i++) {
				char tmp = input.charAt(i);

				switch (tmp) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					s = s + tmp;
					break;
				}

				case '+':
				case '-':
				case '*':
				case '/': {
					ops.push(String.valueOf(tmp));
					if (s.trim().length() > 0) {
						nums.push(s);
						s = "";

					}
					break;
				}

				case ')': {
					if (s.trim().length() > 0) {
						nums.push(s);
						s = "";

					}
					String a = " " + ops.pop() + " " + nums.pop() + " )";
					a = "( " + nums.pop() + a;
					nums.push(a);
					break;
				}

				default:
					break;
				}

			}
			return nums.pop();
		}


}
