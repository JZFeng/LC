package jz.lc.easy;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 4, 8, 8, 8, 9, 10 };
		System.out.println(binarySearchFirstPosition(8, nums));
		System.out.println(binarySearchLastPosition(8, nums));
		System.out.println(binarySearch(8, nums));

	}

	public static int binarySearch(int key, int[] a) {
		if (a == null || a.length == 0)
			return -1;

		int left = 0;
		int right = a.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] == key)
				return mid;
			else if (a[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return -1;
	}

	public static int binarySearchLastPosition(int target, int[] a) {
		if (a == null || a.length == 0)
			return -1;

		int start = 0;
		int end = a.length - 1;
		while (start + 1 < end) { // 相邻
			int mid = start + (end - start) / 2;
			if (a[mid] == target) {
				start = mid;
			} else if (a[mid] > target) {
				end = mid;
			} else {
				start = mid;
			}
		}

		if (a[end] == target) {
			return end;
		}

		if (a[start] == target) {
			return start;
		}

		return -1;

	}

	public static int binarySearchFirstPosition(int target, int[] a) {
		if (a == null || a.length == 0)
			return -1;

		int start = 0;
		int end = a.length - 1;
		while (start + 1 < end) { // 相邻
			int mid = start + (end - start) / 2;
			if (a[mid] == target) {
				end = mid;
			} else if (a[mid] > target) {
				end = mid;
			} else if(a[mid] < target){
				start = mid;
			}
		}

		if (a[start] == target) {
			return start;
		}
		if (a[end] == target) {
			return end;
		}

		return -1;

	}

	public static int binarySearch(int key, int[] a, int low, int high) {
		if (a == null || a.length == 0)
			return -1;
		if (low > high)
			return -1;
		else {
			int mid = low + (high - low) / 2;
			if (key < a[mid])
				return binarySearch(key, a, 0, mid - 1);
			else if (key == a[mid]) {
				return mid;
			} else {
				return binarySearch(key, a, mid + 1, high);
			}
		}

	}

}
