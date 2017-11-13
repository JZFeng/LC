package jz.LadderOnly;

import java.util.Comparator;
import java.util.PriorityQueue;

//http://lintcode.com/en/problem/k-closest-points/
public class KCloestestPoints {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	private Point global_origin = null;

	public Point[] kClosest(Point[] points, Point origin, int k) {
		// write your code here
		global_origin = origin;
		PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point a, Point b) {
				int diff = getDistance(b, global_origin) - getDistance(a, global_origin);
				if (diff == 0) {
					diff = b.x - a.x;
				}
				if (diff == 0) {
					diff = b.y - a.y;
				}
				return diff;
			}
		});
		for (Point p : points) {
			pq.offer(p);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		k = pq.size();
		Point[] result = new Point[k];
		while (!pq.isEmpty()) {
			result[--k] = pq.poll();
		}
		return result;
	}

	private int getDistance(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}

}
