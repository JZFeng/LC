/*
 https://leetcode.com/problems/missing-number/#/description
 
 268. Missing Number
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity? 
 
  
 */
package jz.lc.easy;

import java.util.Arrays;

import jz.Util;

public class MissingNumber
{

    public static void main(String[] args)
    {
        int[] nums = new int[]{0,1,3};
        Util.printArray(nums);
        System.out.println(missingNumberII(nums));

    }
    
    //binary search
    public static int missingNumberII(int[] nums) {
        Arrays.sort(nums);
        int left = 0; int right = nums.length;
        while(left < right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid] > mid)
                right = mid;
            else
                left = mid+1;
        }
        
        return left;
    }
    
    //xor
    public static int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length;i++)
        {
            res = res ^ nums[i] ^(i+1);
        }
        return res;
    }

  //arithmetic progression 等差数列
    public static int missingNumberIII(int[] nums) {
       int sum = (nums.length+1)*nums.length/2;
       for(int num: nums)
           sum-=num;
       
       return sum;
    }
}
