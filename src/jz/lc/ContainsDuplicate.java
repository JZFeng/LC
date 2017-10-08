/*
https://leetcode.com/problems/contains-duplicate/#/description

217. Contains Duplicate

Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, 
and it should return false if every element is distinct.

 */
package jz.lc;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate
{

    public static void main(String[] args)
    {
        System.out.println(containsDuplicate(new int[]{1,2}));

    }
    
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set =  new HashSet<Integer>(); 
        
        for(int num:nums)
        {
            if(!set.add(num) )
                return true;
        }
        return false;
    }

}
