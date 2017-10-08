package jz.lc;

// http://www.geeksforgeeks.org/maximum-difference-between-two-elements/


public class MaximumDifference {

    public static void main(String[] args) {
	int[] arr1 = new int[]{2, 3, 10, 6, 4, 8, 1};
	int[] arr2 = new int[]{7, 9, 5, 6, 3, 2};
	System.out.println(maxDifference(arr1) + " ; " + maxDifference(arr2));
	System.out.println(maxDifference2(arr1) + " ; " + maxDifference2(arr2));
    }
    
    //brutal force, double loop , 固定一端
    public static int maxDifference(int[] arr) {
	if(arr == null || arr.length < 2) {
	    return -1;
	}
	
	int max_diff = arr[1] - arr[0];
	for(int i = 0 ; i < arr.length; i++) {
	    for(int j = i + 1; j < arr.length; j++) {
		if( arr[j] - arr[i] > max_diff) {
		    max_diff = arr[j] - arr[i];
		}
	    }
	}
	
	return max_diff > -1 ? max_diff : -1;
    }

    public static int maxDifference2(int[] arr) {
	if(arr == null || arr.length < 2) {
	    return -1;
	}
	
	int max_diff = -1;
	int min = arr[0];
	for(int i = 1; i < arr.length; i++) {
	    if((arr[i] - min) > max_diff) {
		max_diff = arr[i] - min;
	    }
	    min = Math.min(min,  arr[i]);
	}
	
	return max_diff;
    }
}
