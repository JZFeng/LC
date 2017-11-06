package jz.lc.jiuzhang;

/*
 http://lintcode.com/en/problem/find-peak-element/
  
 */
public class FindPeakElement {

	/*
	 * @param A: An integers array.
	 * 
	 * @return: return any of peek positions.
	 */
	public int findPeak(int[] A) {
		// write your code here
		int start = 0;
		int end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
				return mid;
			} else if (A[mid] > A[mid - 1] && A[mid] < A[mid + 1]) {
				start = mid;
			} else if (A[mid] < A[mid - 1] && A[mid] > A[mid + 1]) {
				end = mid;
			} else if (A[mid] < A[mid - 1] && A[mid] < A[mid + 1]) {
				end = mid;
			}
		}
		return A[start] > A[end] ? start : end;
	}

}
