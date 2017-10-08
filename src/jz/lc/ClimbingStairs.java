/**
 https://leetcode.com/problems/climbing-stairs/#/description
 
 70. Climbing Stairs
 
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

 */
package jz.lc;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class ClimbingStairs {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(climbStairs(50));
		System.out.println("non-recursion running time:  " + (System.currentTimeMillis() - startTime));

		startTime = System.currentTimeMillis();
		System.out.println(climbStairsII(50));
		System.out.println("Recursion running time:  " + (System.currentTimeMillis() - startTime));
	}

	public static long climbStairs(int n) {
		if (n < 0)
			return 0;
		if (n <= 2)
			return n;

		long[] ways = new long[n];
		ways[0] = 1;
		ways[1] = 2;
		for (int i = 2; i < n; i++) {
			ways[i] = ways[i - 1] + ways[i - 2];
		}

		return ways[n - 1];
	}

	public static long climbStairsII(int n) {
		if (n < 0)
			return 0;
		if (n <= 2)
			return n;

		return climbStairsII(n - 1) + climbStairsII(n - 2);

	}
}
