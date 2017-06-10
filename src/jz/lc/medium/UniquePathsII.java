/**
https://leetcode.com/problems/unique-paths-ii/#/description

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

Note: m and n will be at most 100.
 *
 */
package jz.lc.medium;

/**
 *@author jzhfeng
 *@date May 10, 2017
 */
public class UniquePathsII
{

    public static void main(String[] args)
    {

    }

    public int uniquePathsWithObstacles(int[][] grid)
    {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

    	int m = grid.length;
    	int n = grid[0].length;
		int[][] f = new int[m][n];
		

		for (int i = 0; i < m; i++) {
			if(grid[i][0] != 1){
				f[i][0] = 1;
			}
			else{
				break;
			}
		}

		for (int j = 0; j < n; j++) {
			if(grid[0][j] != 1){
				f[0][j] = 1;
			}
			else{
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if(grid[i][j] != 1){
					f[i][j] = f[i - 1][j] + f[i][j - 1];
				}
				else{
					f[i][j] = 0;
				}
			}
		}

		return f[m - 1][n - 1];

	
    }

}
