/**
 http://www.geeksforgeeks.org/count-number-of-bits-to-be-flipped-to-convert-a-to-b/
 
 Question: You are given two numbers A and B. 
 Write a program to count number of bits needed to be flipped to convert A to B.
 */
package jz.lc.easy;

/**
 *@author jzhfeng
 *@date May 18, 2017
*/
public class ConvertIntegerAtoB
{

    public static void main(String[] args)
    {
        int a = 234545;
        int b = 278592002;
        System.out.println(bitSwapRequired(a, b));

    }
    
    public static int bitSwapRequired(int a, int b) 
    {
        int xor = a ^ b;
        System.out.println(Integer.toBinaryString(xor));
        int count = 0;
        
        while(xor != 0)
        {
        	count++;
            xor = xor & (xor-1);  // effect of statement x & (x - 1) is get rid of bit 1 of the lowest position.
        }
        return count;
    }

}
