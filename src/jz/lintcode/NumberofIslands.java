package jz.lintcode;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
	int x, y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class NumberofIslands {

    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 ) {
            return 0;
        }
        
        int m = grid.length; 
        int n = grid[0].length;
        int count = 0;
        for (int i = 0 ; i < m; i++) {
            for (int j = 0 ; j < n; j++) {
                if ( grid[i][j] ) {
                    count++;
                    markGridBFS(new Coordinate(i, j), grid );
                }
            }
        }
        
        return count;
    }
    
    //BFS 
    private void markGridBFS(Coordinate co, boolean[][] grid) {
        int[] directionX = {0, 0, 1,-1} ;
        int[] directionY = {-1,1, 0, 0} ;
        grid[co.x][co.y] = false;
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        queue.offer(co);
        while ( !queue.isEmpty() ) {
        	Coordinate coor = queue.poll();
            for (int i = 0 ; i < 4 ; i++) {
                Coordinate tmp = new Coordinate(coor.x + directionX[i],
                                         		coor.y + directionY[i]);
                if (inBound(tmp, grid) && grid[tmp.x][tmp.y]) {
                    grid[tmp.x][tmp.y] = false;
                    queue.offer(tmp);
                }                                    
            }
        }
    }
    
    
    private boolean inBound(Coordinate coor, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return coor.x >=0 && coor.x < m && coor.y >=0 && coor.y < n;
    }

}
