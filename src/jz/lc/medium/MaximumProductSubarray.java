/*
 https://leetcode.com/problems/maximum-product-subarray/#/description
 
 152. Maximum Product Subarray
 
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
  
 */
package jz.lc.medium;

public class MaximumProductSubarray
{

    public static void main(String[] args)
    {
        int[] nums = new int[]{2,0};
        System.out.println(maxProduct(nums));

    }
    
    public static int maxProduct(int[] nums)
    {
        int max = nums[0];
        int min = nums[0];
        int global_max = nums[0];
        
        for(int i = 1; i < nums.length ; i++){
            int tmp = max;
            max = Math.max( Math.max(max*nums[i], nums[i] ), min*nums[i] );
            min = Math.min( Math.min(tmp*nums[i], nums[i] ), min*nums[i] );
            global_max = Math.max(max, global_max);
        }
        
        return global_max;
        
    }

}
