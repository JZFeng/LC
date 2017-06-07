package jz.Sorting;

public class QuickSort {

	public static void main(String[] args) {

	}

	public static void quickSort(int[] a, int low, int high) {
		if (a == null || a.length == 0)
			return;

		if (low <= high) {
			int q = partition(a, low, high);
			if (low < q)
				quickSort(a, low, q - 1);

			if (high > q)
				quickSort(a, q + 1, high);
		}
	}

	private static int partition(int[] a, int left, int right) {
		int i = left;
		int j = right;
		int pivot = a[i];

		while (i < j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;

			if (i < j) {
				swap(a, i, j);

				if (a[i] == a[j])
					i++;
			}
		}

		return i;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
