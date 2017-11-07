package jz.NineChapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//http://lintcode.com/en/problem/knight-shortest-path/
public class KnightShortestPath {

	public class Point {
		public int x, y;

		public Point() {
			x = 0;
			y = 0;
		}

		public Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	private int[] directionX = { 1, 1, -1, -1, 2, 2, -2, -2 };
	private int[] directionY = { 2, -2, 2, -2, 1, -1, 1, -1 };

	public int shortestPath(boolean[][] grid, Point source, Point destination) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return -1;
		}

		Queue<Point> queue = new LinkedList<>();
		queue.offer(source);
		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				Point p = queue.poll();
				if (p.x == destination.x && p.y == destination.y) {
					return steps;
				}

				for (int i = 0; i < 8; i++) {
					Point adj = new Point(p.x + directionX[i], p.y + directionY[i]);
					if (inBound(adj, grid)) {
						queue.offer(adj);
						grid[adj.x][adj.y] = true;
					}
				}
			}

			steps++;

		}

		return -1;

	}

	private boolean inBound(Point p, boolean[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		if (p.x < 0 || p.x >= m) {
			return false;
		}
		if (p.y < 0 || p.y >= n) {
			return false;
		}

		return (grid[p.x][p.y] == false);
	}

}
