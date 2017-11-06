/*
 https://leetcode.com/problems/power-of-two/#/description
 
 231. Power of Two
 
 Given an integer, write a function to determine if it is a power of two.
 
 */
package jz.deprecated;

public class PowerofTwo {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwoII(9));

	}

	public static boolean isPowerOfTwo(int n) {
		if (n < 1)
			return false;

		int count = 0;

		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1)
				count++;
			n = n >> 1;
		}
		return count == 1;

	}

	public static boolean isPowerOfTwoII(int n) {
		return (n & (n - 1)) == 0;
	}

}
