/**
 https://leetcode.com/problems/sqrtx/#/description
 
 69. Sqrt(x)
 
 Implement int sqrt(int x).

Compute and return the square root of x.

 *
 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class SqrtX {

	public static void main(String[] args) {
		System.out.println(sqrt(10));

	}

	// The Binary Search can be further optimized to start with 'left' = 0 and
	// 'right' = x/2.
	// Floor of square root of x cannot be more than x/2 when x > 1.

	public static int sqrt(int x) {
		if (x <= 1)
			return x;

		int left = 1, right = x / 2;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (x / mid == mid)
				return mid;
			else if (x / mid < mid)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return right;
	}

}
