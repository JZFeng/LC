/**
 *
 https://leetcode.com/problems/minimum-path-sum/#/description
 
 64. Minimum Path Sum
 
 Given a m x n grid filled with non-negative numbers, 
 
 find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 
 *
 */
package jz.Lintcode;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] grid = new int[3][4];
		grid[0] = new int[] { 2, 3, 6, 7 };
		grid[1] = new int[] { 2, 8, 9, 2 };
		grid[2] = new int[] { 3, 7, 8, 12 };

		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int M = grid.length; // number of lines
		int N = grid[0].length; // number of rows
		int[][] f = new int[M][N]; //记忆化搜索的数组
		f[0][0] = grid[0][0]; //初始化
		for (int i = 1; i < M; i++) {
			f[i][0] = f[i - 1][0] + grid[i][0]; //记得一定要相加
		}

		for (int j = 1; j < N; j++) {
			f[0][j] = f[0][j - 1] + grid[0][j]; //记得一定要相加
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j]; //递推公式
			}
		}

		return f[M - 1][N - 1];

	}

}
