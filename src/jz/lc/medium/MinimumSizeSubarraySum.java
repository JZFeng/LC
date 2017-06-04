/*
 https://leetcode.com/problems/minimum-size-subarray-sum/#/description
 
 209. Minimum Size Subarray Sum
 
Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
  
 */
package jz.lc.medium;

public class MinimumSizeSubarraySum
{
    public static void main(String[] args)
    {
        int[] nums = new int[]
//        { 2, 3, 1, 2, 4, 3, 8, 5, 2, 1 };
         {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));

    }

/*
 我们用两个指针维护一个窗口，保证这个窗口的内的和是小于目标数的。
 如果新来的数加上后，和大于目标，则比较下当前窗口长度和最短窗口长度，窗口左边界右移。
 如果和仍小于目标数，则将窗口右边界右移。
     
//套路：向前指针，窗口，j指针只向前

    
    //模版：
    for(i = 0 ; i < n; i++){
        while(j < n){
            if(满足条件){
                j++;
                更新j状态;
            }
            else(不满足条件)
                break;
        }
        更新i状态;
    }
*/
    
    public static int minSubArrayLen(int s, int[] nums)
    {
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        
        for(i = 0 ; i < nums.length;i++){
            while(j < nums.length) {
                if(sum < s){
                    //更新j状态，即窗口右界移动
                    sum += nums[j]; 
                    j++;
                }
                else
                    break;
            }
            
            if(sum >= s){
                //更新i状态，即窗口左界右移
                ans = Math.min(ans, j-i);
                sum -= nums[i];
            }
            
        }
        
        if(ans == Integer.MAX_VALUE)
            ans = 0;
        
        return ans;
    }

}
