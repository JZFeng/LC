package jz.lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

	/**
	 * @param numCourses
	 *            a total of n courses
	 * @param prerequisites
	 *            a list of prerequisite pairs
	 * @return true if can finish all courses or false
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses == 0) {
			return true;
		}
		if (prerequisites == null || prerequisites.length == 0) {
			return true;
		}

		// build up adjacency matrix and initianlize it
		List[] courses = new ArrayList[numCourses];
		for (int i = 0; i < courses.length; i++) {
			courses[i] = new ArrayList<Integer>();
		}

		int[] indegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			indegree[prerequisites[i][0]]++;
			courses[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			ArrayList<Integer> neighbors = (ArrayList<Integer>) courses[course];
			for (int i = 0; i < neighbors.size(); i++) {
				indegree[neighbors.get(i)]--;
				if (indegree[neighbors.get(i)] == 0) {
					queue.offer(neighbors.get(i));
				}
			}
		}

		return count == numCourses;

	}

}
