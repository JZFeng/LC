/**
 https://leetcode.com/problems/power-of-two/#/description
 
 Given an integer, write a function to determine if it is a power of two.
 
 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 18, 2017
 */
public class CheckPowerofTwo {

	public static void main(String[] args) {
		for (int i = -2; i < 260; i++) {
			if (isPowerOfTwo(i))
				System.out.println(i);

		}

	}

	public static boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;

		return ((n & (n - 1)) == 0);

	}

	public static boolean isPowerOfTwoI(int n) {
		if (n <= 0)
			return false;

		while (n > 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}

		return true;

	}

}
