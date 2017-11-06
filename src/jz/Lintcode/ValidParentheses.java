/**
 *
https://leetcode.com/problems/valid-parentheses/#/description

20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 

determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */
package jz.Lintcode;

import java.util.Stack;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("}"));

	}

	public static boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return true;

		if (s.length() % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '(' || c == '{')
				stack.push(c);

			else if (!stack.isEmpty()) {
				if ((c == ']' && stack.peek() != '[') || (c == ')' && stack.peek() != '(')
						|| (c == '}' && stack.peek() != '{'))
					return false;

				stack.pop();
			}
		}

		return stack.isEmpty();

	}

}
