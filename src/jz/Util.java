package jz;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Util {

	public static void main(String[] args) throws IOException {
		int[] nums = new int[15];
		int i = 5;
		int left  = i * 2 + 1; //11
		int right = i * 2 + 2; //12
		System.out.println((right - 1) /2 );
		
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
