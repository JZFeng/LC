/**
https://leetcode.com/problems/two-sum/#/description

1 Two Sum
 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
package jz.lc.easy;

import java.util.HashMap;
import jz.Util;

public class TwoSum
{

    public static void main(String[] args)
    {
        int[] nums = new int[]{2,8,8,21,18};
        int[] a = twoSum(nums, 16);
        Util.printArray(a);

    }

    public static int[] twoSum(int[] nums, int target)
    {
        int[] results = new int[2];
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length; i++)
        {
            if(hashmap.containsKey(target - nums[i]))
            {
                results[0] = hashmap.get(target - nums[i]) ;
                results[1] = i;
            }
            else
            {
                hashmap.put(nums[i], i);
            }
        }
        
        return results;
    }
}
