package jz.Sorting;

import jz.Util;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = new int[]{3,23,2,12,21, 904,28};
	}
	

	public static int[] mergeSortedArray(int[] A, int[] B) {
		if (A == null || B == null) {
			return (A == null) ? B : A;
		}
		if (A.length == 0 || B.length == 0) {
			return (A.length == 0) ? B : A;
		}

		int[] res = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < A.length && j < B.length) {
			if (A[i] > B[j]) {
				res[index++] = B[j++];
			} else {
				res[index++] = A[i++];
			}
		}

		while (i < A.length) {
			res[index++] = A[i++];
		}

		while (j < B.length)
			res[index++] = B[j++];
		
		return res;
	}
}
