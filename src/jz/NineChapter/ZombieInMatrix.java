package jz.NineChapter;

import java.util.LinkedList;
import java.util.Queue;

//http://lintcode.com/en/problem/zombie-in-matrix/
public class ZombieInMatrix {
	class Coordinate {
		int x;
		int y;

		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public class Solution {
		private int PEOPLE = 0;
		private int ZOMBIE = 1;
		private int WALL = 2;
		private int[] directionX = { 0, 0, -1, 1 };
		private int[] directionY = { -1, 1, 0, 0 };

		public int zombie(int[][] grid) {
			// Write your code here
			if (grid == null || grid.length == 0 || grid[0].length == 0) {
				return 0;
			}

			int numPeople = 0;
			int days = 0;
			int m = grid.length;
			int n = grid[0].length;
			Queue<Coordinate> queue = new LinkedList<>();
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == PEOPLE) {
						numPeople++;
					} else if (grid[i][j] == ZOMBIE) {
						queue.offer(new Coordinate(i, j));
					}
				}
			}

			if (numPeople == 0) {
				return days;
			}

			while (!queue.isEmpty()) {
				days++;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Coordinate z = queue.poll();
					for (int j = 0; j < 4; j++) {
						if (isPeople(z.x + directionX[j], z.y + directionY[j], grid)) {
							grid[z.x + directionX[j]][z.y + directionY[j]] = ZOMBIE;
							numPeople--;
							if (numPeople == 0) {
								return days;
							}
							queue.offer(new Coordinate(z.x + directionX[j], z.y + directionY[j]));
						}
					}
				}
			}

			return -1;
		}

		private boolean isPeople(int x, int y, int[][] grid) {
			int m = grid.length;
			int n = grid[0].length;
			if (x < 0 || x >= m) {
				return false;
			}
			if (y < 0 || y >= n) {
				return false;
			}

			return (grid[x][y] == PEOPLE);
		}
	}
}
