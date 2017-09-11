/**

https://leetcode.com/problems/reverse-integer/#/description

7. Reverse Integer
 
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321



Have you thought about this?
Here are some good questions to ask before coding. 
Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? 
Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 
 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}

	public static int reverse(int n) {
		int result = 0;
		while (n != 0) {
			int tail = n % 10;
			int tmp = result * 10 + tail;
			if (tmp / 10 != result) {
				return 0;
			}
			result = tmp;
			n = n / 10;

		}

		return result;
	}
}
