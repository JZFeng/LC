/**
 https://leetcode.com/problems/rotate-array/#/description
 
 189. Rotate Array
 
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, 
there are at least 3 different ways to solve this problem.
 
 */
package jz.lc.easy;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 21, 2017
 */
public class RotateArray
{

    public static void main(String[] args)
    {
        int[] a = new int[]
        { 1, 2 };
        Util.printArray(a);
        rotate(a, 3);
        Util.printArray(a);

    }

    public static void rotate(int[] nums, int k)
    {
        if (k > nums.length)
            k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private static void reverse(int[] nums, int i, int j)
    {
        if (nums.length <= 1)
            return;

        while (i < j)
        {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

}
