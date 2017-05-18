/**
 https://leetcode.com/problems/factorial-trailing-zeroes/#/description
 
172. Factorial Trailing Zeroes Add to List

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 
 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 18, 2017
 */
public class FactorialTrailingZeroes
{

    public static void main(String[] args)
    {
        System.out.println(trailingZeroes(30));
        
        int count = 0;
        for (int i = 1; i <= 30; i++)
        {
            if(i%5 == 0) count++;
            
        }
        System.out.println(count);

    }

    public static int trailingZeroes(int n)
    {
        int count = 0;
        
        while(n >0 )
        {
            count = count + n/5;
            n = n/5;
        }

        return count;
    }

}
