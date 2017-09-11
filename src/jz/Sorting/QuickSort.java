package jz.Sorting;

import jz.Util;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,2,4};
		Util.printArray(nums);
		sortInteger(nums);
		Util.printArray(nums);
	}
	
	private static void sortInteger(int[] nums ) {
		quickSortII(nums, 0 , nums.length - 1);
	}
	
	private static void quickSortII(int[] nums, int start, int end ) {
		if (start >= end) {
			return;
		}
		
		int p = partition( nums, start, end);
		quickSortII(nums, start, p - 1);
		quickSortII(nums, p , end);
	}
	
	private static int partition( int[] nums, int start , int end ) {
		if (start >= end) {
			return - 1;
		}
		
		int left = start;
		int right = end;
		int mid = left + (start - left) / 2;
		int pivot = nums[mid];
		while (left <= right) {
			while (left <= right && nums[left] < pivot ) {
				left++;
			}
			while (left <= right && nums[right] > pivot ) {
				right--;
			}
			if (left <= right) {
				int tmp = nums[left] ;
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		}

		return left;
	}
	
	
	private static void quickSort(int[] nums, int start, int end) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		if (start >= end) {
			return;
		}
		
		int left = start;
		int right = end;
		int mid = left + (right - left) / 2;
		int pivot = nums[mid];
		
		while( left <= right ) { 
			while ( left <= right && nums[left] < pivot ) {
				left++;
			}
			while (left <= right && nums[right] > pivot ) {
				right--;
			}
			
			if ( left <= right) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		}
		
		quickSort(nums, start, right);
		quickSort(nums, left, end);
		
	}
}
