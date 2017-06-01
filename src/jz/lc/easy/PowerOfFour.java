/*
https://leetcode.com/problems/power-of-four/#/description

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion? 
 */
package jz.lc.easy;

public class PowerOfFour
{

    public static void main(String[] args)
    {
        System.out.println(isPowerOfFourII(16));
    }
    
    public static boolean isPowerOfFour(int num) {
        if(num < 1) return false;
        while(num > 0 && num%4 == 0)
            num = num/4;
        
        return num == 1;
    }

    //0x7FFFFFFF is the Integer_MAX_VALUE
    //0X55555555 is 01010101010101010101010101010101
    public static boolean isPowerOfFourII(int num) {
//      return (num & num-1)==0 && (num&0x55555555)==num;
        return (num & num-1)==0 && (num -1)%3 ==0;
    }
    
}
