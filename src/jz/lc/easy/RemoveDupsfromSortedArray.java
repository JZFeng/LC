/**

https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description

26. Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.

 *
 */
package jz.lc.easy;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class RemoveDupsfromSortedArray
{

    public static void main(String[] args)
    {
        int[] nums = new int[]
        { 1, 1, 1, 2, 2, 3, 3 };
        int newSize = removeDuplicates(nums);
        for (int i = 0; i < newSize; i++)
            System.out.print(nums[i] + " ");

    }

    public static int removeDuplicates(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int i = 1;
        int j = 0;
        while (i < nums.length && j < nums.length)
        {
            if (nums[i] == nums[i - 1])
            {
                i++;
            }
            else
            {
                nums[j] = nums[i - 1];
                j++;
                i++;
            }

        }
        nums[j] = nums[i - 1];
        return j + 1;
    }

}
