package jz.LadderOnly;

import java.util.Arrays;

//http://lintcode.com/en/problem/remove-duplicate-numbers-in-array/
	
public class RemoveDuplicateNumbersinArray {
	public class Solution {
	    /**
	     * @param nums an array of integers
	     * @return the number of unique integers
	     */
	    public int deduplication(int[] nums) {
	        // Write your code here
	        if ( nums == null || nums.length == 0) {
	            return 0;
	        }
	        
	        Arrays.sort(nums);
	        int i = 1;
	        int j = 1;
	        while ( j < nums.length) {
	            if ( nums[j] == nums[j - 1])  {
	                j++;
	            } else {
	                nums[i++] = nums[j++];
	            }
	        }
	        
	        return i ;
	    }
	}
}
