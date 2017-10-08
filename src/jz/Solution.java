package jz;

import java.io.*;
import java.util.*;

public class Solution {
    /*
     * The function assumes that there are at least two elements in array. The
     * function returns a negative value if the array is sorted in decreasing
     * order. Returns 0 if elements are equal
     */
    int maxDiff(int arr[], int arr_size) {
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
