package jz.lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Coordinate {
	int x, y;
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class NumberofIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> res = new ArrayList<>();
		ArrayList<Integer> subset = new ArrayList<>();
		res.add(new ArrayList<Integer>(subset));
		res.add(new ArrayList<Integer>(subset));
		for(List<Integer> a : res) {
			System.out.println(a);
		}
		subset.add(1);
		res.add(new ArrayList<Integer>(subset));
		for(List<Integer> a : res) {
			System.out.println(a);
		}
	}


	public class Solution {
	    /**
	     * @param grid a boolean 2D matrix
	     * @return an integer
	     */
	    public int numIslands(boolean[][] grid) {
	        if (grid == null || grid.length == 0 || grid[0].length == 0) {
	            return 0;
	        }
	        
	        int n = grid.length;
	        int m = grid[0].length;
	        int islands = 0;
	        
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (grid[i][j]) {
	                    markByBFS(grid, i, j);
	                    islands++;
	                }
	            }
	        }
	        
	        return islands;
	    }
	    
	    private void markByBFS(boolean[][] grid, int x, int y) {
	        // magic numbers!
	        int[] directionX = {0, 0, 1, -1};
	        int[] directionY = {1, -1, 0, 0};
	        
	        Queue<Coordinate> queue = new LinkedList<>();
	        queue.offer(new Coordinate(x, y));
	        grid[x][y] = false;
	        
	        while (!queue.isEmpty()) {
	            Coordinate coor = queue.poll();
	            for (int i = 0; i < 4; i++) {
	                Coordinate adj = new Coordinate(
	                    coor.x + directionX[i],
	                    coor.y + directionY[i]
	                );
	                if (!inBound(adj, grid)) {
	                    continue;
	                }
	                if (grid[adj.x][adj.y] == true) {
	                    grid[adj.x][adj.y] = false;
	                    queue.offer(adj);
	                }
	            }
	        }
	    }
	    
	    private boolean inBound(Coordinate coor, boolean[][] grid) {
	        int n = grid.length;
	        int m = grid[0].length;
	        
	        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
	    }
	}

}
