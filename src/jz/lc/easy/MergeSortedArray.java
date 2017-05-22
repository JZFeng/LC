/**

https://leetcode.com/problems/merge-sorted-array/#/description

88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 

The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */
package jz.lc.easy;

import jz.Util;

/**
 *@author jzhfeng
 *@date May 10, 2017
 */
public class MergeSortedArray
{

    public static void main(String[] args)
    {
        int[] nums1 = new int[]{6,8,9,12,0,0,0,0,0,0};
        
        int[] nums2 = new int[]{1,2,9};
        
        merge(nums1,4,nums2,nums2.length);
        Util.printArray(nums1);
        

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int index = m+n-1;
        int j = n-1; int i = m-1;
        
        while(j >=0 && i >=0)
        {
            if(nums2[j] > nums1[i])
            {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
            else
            {
                nums1[index] = nums1[i];
                index--;
                i--;
            }
            
        }
        
        while(i >=0)
        {
            nums1[index--] = nums1[i--];
        }
        
        while(j >=0)
        {
            nums1[index--] = nums2[j--];
        }
        

    }

}
