/**
https://leetcode.com/problems/unique-paths/#/description

62. Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 

The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

 */

package jz.Deprecated;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class UniquePaths {

	public static void main(String[] args) {

	}

	public int uniquePaths(int m, int n) {

		if (m == 0 || n == 0) {
			return 1;
		}

		if (m == 1 || n == 1) {
			return 1;
		}

		int[][] f = new int[m][n];
		f[0][0] = 0;
		for (int i = 1; i < m; i++) {
			f[i][0] = 1;
		}

		for (int j = 1; j < n; j++) {
			f[0][j] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				f[i][j] = f[i - 1][j] + f[i][j - 1];
			}
		}

		return f[m - 1][n - 1];

	}
}
