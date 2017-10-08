/*
 215. Kth Largest Element in an Array
 https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
  
 */
package jz.lc;

import java.util.Comparator;
import java.util.PriorityQueue;

import jz.Util;

public class KthLargestElementinanArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3,9, 4, 8};
		Util.printArray(nums);
		int position = partition(nums, 0 , nums.length - 1);
		System.out.println(position);
		Util.printArray(nums);
	}

    private static int partition(int[] nums, int start, int end) {
    	if(start == end) {
    		return start;
    	}
    	
        int left = start;
        int right = end;
        int middle =  left + (right - left) / 2;
        int pivot = nums[middle];
        while(left <= right) {
            while(left <= right && nums[left] < pivot ) {
                left++;
            }
            while(left <= right && nums[right] > pivot ) {
                right--;
            }
            if(left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }
        
        return left - 1;
    }
	
	
}
