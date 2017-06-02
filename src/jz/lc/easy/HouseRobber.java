/**
 https://leetcode.com/problems/house-robber/#/description
 
 198. House Robber
 
 You are a professional robber planning to rob houses along a street. 
 Each house has a certain amount of money stashed, 
 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.


 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 14, 2017
 */
public class HouseRobber
{

    public static void main(String[] args)
    {
        int[] nums = new int[]
         {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,165,180,214,151,111,161,233,147,124,143};
//        {1,3,5,7,9};
        System.out.println(rob(nums));
    }


    public static int result[];
    
    public static int rob(int idx, int[] nums)
    {
        if(idx >= nums.length || idx < 0 )
            return 0;
        
        if(result[idx] >=0)
            return result[idx];
        
        result[idx] =  Math.max(
            nums[idx] + rob(idx-2, nums),
            rob(idx-1,nums)     
            );
        
        
        return result[idx];        
        
    }
    
    
    public static int rob(int[] nums) {
        result = new int[nums.length];
        for(int i = 0 ; i < nums.length;i++)
        {
            result[i] = -1;
        }
        
        return rob(nums.length -1, nums);
        
    }
    
}
