/*
 https://leetcode.com/problems/power-of-three/#/description
 
 326. Power of Three

 Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 
 */
package jz.lc.easy;

public class PowerofThree {

	// 0x7FFFFFFF is the Integer_MAX_VALUE
	// 0X55555555 is 1010101010101010101010101010101
	public static void main(String[] args) {
		System.out.println(isPowerOfThreeII(10));
		System.out.println(Integer.toHexString(Integer.MAX_VALUE));

	}

	public static boolean isPowerOfThree(int n) {
		while (n > 0 && n % 3 == 0) {
			n = n / 3;
		}

		return n == 1;

	}

	public static boolean isPowerOfThreeII(int n) {
		return Math.log10(n) / Math.log10(3) % 1 == 0;

	}

	public static boolean isPowerOfThreeIII(int n) {
		int maxPowerFactor = (int) (Math.log10(Integer.MAX_VALUE) / Math.log10(3));
		return n > 0 && Math.pow(3, maxPowerFactor) % n == 0;
	}

}
