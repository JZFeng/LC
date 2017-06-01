/**
 https://leetcode.com/problems/move-zeroes/#/description
 
 283. Move Zeroes
 
 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
1 You must do this in-place without making a copy of the array.
2 Minimize the total number of operations.

 */
package jz.lc.easy;

import jz.Util;

/**
 * @author jzhfeng
 * @date May 11, 2017
 */
public class MoveZeroes
{

    public static void main(String[] args)
    {
        int[] a = new int[]
        {0,1,0,3,12};
        Util.printArray(a);
        moveZeroes(a);
        Util.printArray(a);

    }

    public static void moveZeroes(int[] a)
    {
        int j = 0;
        for(int i = 0 ; i <a.length; i++)
        {
            if(a[i] != 0)
            {
                swap(a,i,j);
                j++;
            }
        }
    }
    
    public static void moveZeroesII(int[] a)
    {
        if (a == null || a.length < 2)
            return;

        int i = 0;
        int j = 0;

        while (j < a.length)
        {
            if ((a[i] != 0))
                i++;
            if (a[j] == 0)
                j++;
            if (i < j)
            {
                Util.swap(a, i, j);
                j++;
            }
            else
            {
                j++;
            }

        }

    }

    
    private static void swap(int[] a, int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
