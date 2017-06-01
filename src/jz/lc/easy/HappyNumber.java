/*
 https://leetcode.com/problems/happy-number/#/description
 202. Happy Number
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
  
 */
package jz.lc.easy;

import java.util.HashSet;

public class HappyNumber
{

    public static void main(String[] args)
    {
        System.out.println(isHappyII(22));
    }
    
    //Floyd Cycle detection algorithm
    public static int isHappyII(int n)
    {
        int fast = n;
        int slow = n;
        int count = 0;
        do
        {
            count++;
            slow = getSquareSum(slow);
            System.out.print(slow +"->");
            fast = getSquareSum(fast);
            fast = getSquareSum(fast);
        } while (fast != slow);
        return count;
    }
    

    public static boolean isHappy(int n)
    {
        if(n > 0)
        {
            int squareSum = getSquareSum(n);
            HashSet<Integer> hashset = new HashSet<Integer>();
            while(hashset.add(squareSum))
            {
                squareSum = getSquareSum(squareSum);
            }
            
            return squareSum == 1;
        }
        
        return false;

    }

    
    private static int getSquareSum(int n )
    {
        int sum = 0;
        while(n > 0)
        {
            sum += (n%10)*(n%10);
            n = n/10;
        }
        return sum;
    }
    
}
