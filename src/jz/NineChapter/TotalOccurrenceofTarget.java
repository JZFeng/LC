package jz.NineChapter;

/*
 * http://lintcode.com/en/problem/total-occurrence-of-target/
 */
public class TotalOccurrenceofTarget {

	public int totalOccurrence(int[] A, int target) {
		// write your code here
		if (A == null || A.length == 0) {
			return 0;
		}
		if ((A[A.length - 1] < target) || (A[0] > target)) {
			return 0;
		}
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		int firstTarget = A[start] == target ? start : end;

		start = 0;
		end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		int lastTarget = A[end] == target ? end : start;
		return lastTarget - firstTarget >= 0 ? lastTarget - firstTarget + 1 : 0;
	}

}
