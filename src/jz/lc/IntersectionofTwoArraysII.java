/*
 https://leetcode.com/problems/intersection-of-two-arrays-ii/#/description
 
 350. Intersection of Two Arrays II
 
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, 
and the memory is limited such that you cannot load all elements into the memory at once? 
 */
package jz.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import jz.Util;

public class IntersectionofTwoArraysII
{

    public static void main(String[] args)
    {
        int[] nums1 = new int[]{1, 2,2, 2, 1};
        int[] nums2 = new int[]{2,2,3,4};
        Util.printArray(intersect(nums1, nums2));

    }

    public static int[] intersect(int[] nums1, int[] nums2)
    {
        if(nums1 == null || nums2 == null) 
            return new int[]{};
        
        HashMap<Integer,Integer> hashmap = new HashMap<Integer, Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int num: nums1)
        {
            if(hashmap.containsKey(num))
                hashmap.put(num, hashmap.get(num) + 1);
            else
                hashmap.put(num, 1);
        }
        
        for(int num: nums2)
        {
            if(hashmap.containsKey(num) && hashmap.get(num) > 0 )
            {
                res.add(num);
                hashmap.put(num, hashmap.get(num) -1);
            }
        }
        
        int[] results = new int[res.size()];
        for(int i = 0 ; i < results.length; i++)
            results[i] = res.get(i);
        
        return results;

    }

}
