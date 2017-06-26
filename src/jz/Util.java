package jz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Util {

	public static void main(String[] args) throws IOException {
		int[] nums = new int[] { 4, 5, 6, 6, 7, 7, 1, 1, 1, 2, 2, 3 };

	}


	public boolean searchMatrix(int[][] matrix, int target) {
		// write your code here
		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int start = 0;
		int end = m * n - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;

			if (matrix[mid / n][mid % n] == target) {
				return true;
			} else if (matrix[mid / n][mid % n] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (matrix[start / n][start % n] == target) {
			return true;
		}

		if (matrix[end / n][end % n] == target) {
			return true;
		}

		return false;
	}

	public static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
	}

	public static int rankLT(int key, int[] a) {
		if (key > a[a.length - 1])
			return a.length - 1;

		else if (key < a[0])
			return -1;

		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key == a[mid])
				high = mid - 1;
			else if (key > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		return high;
	}

	public static int rankGT(int key, int[] a) {
		if (key < a[0])
			return 0;
		else if (key > a[a.length - 1])
			return -1;

		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key == a[mid]) {
				low = mid + 1;
			} else if (key < a[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}

		return low;
	}

	public static void printArray(int[] js) {
		if (js == null || js.length == 0) {
			System.out.println("Empty Array");
			return;
		}

		for (int i = 0; i < js.length; i++) {
			System.out.print(js[i] + " ");
		}
		System.out.println();
	}

	public static void printArray(int[] a, int i, int j) {
		if (a.length == 0 || a == null)
			System.out.println("Empty Array");

		while (i <= j) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.println();
	}

}
