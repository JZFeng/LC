/*
 https://leetcode.com/problems/product-of-array-except-self/#/description
 
 238. Product of Array Except Self
 
 Given an array of n integers where n > 1, nums, 
 return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 
 */

package jz.deprecated;

import jz.Util;

public class ProductofArrayExceptSelf
{

    public static void main(String[] args)
    {
        Util.printArray(productExceptSelf(new int[]{2,3,4,5}));

    }
    
    
    public static int[] productExceptSelf(int[] nums) {
    	//我们可以先遍历一遍数组，每一个位置上存之前所有数字的乘积。
    	//那么一遍下来，最后一个位置上的数字是之前所有数字之积，是符合题目要求的.
    	//只是前面所有的数还需要在继续乘。
    	//我们这时候再从后往前扫描，每个位置上的数在乘以后面所有数字之积.
    	//对于最后一个位置来说，由于后面没有数字了，所以乘以1就行。
    	int[] res = new int[nums.length];
    	res[0] = 1;
    	int left = 1;
    	for(int i = 1; i < nums.length; i++){
    		left *= nums[i-1];
    		res[i] = left;
    	}
    	
    	int right = 1;
    	for(int i = nums.length-1; i>=0; i--){
    		res[i] *= right;
    		right *= nums[i];
    	}

    	return res;
        
    }

}
