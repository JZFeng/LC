package jz.Lintcode;

public class MaxDifferenceInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDiff(int arr[], int arr_size) {
		int maxDiff = arr[1] - arr[0];
		int i, j;
		for (i = 0; i < arr_size; i++) {
			for (j = i + 1; j < arr_size; j++) {
				if (arr[j] - arr[i] > maxDiff)
					maxDiff = arr[j] - arr[i];
			}
		}

		return maxDiff;
	}

}
