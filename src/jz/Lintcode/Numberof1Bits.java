/*
 https://leetcode.com/problems/number-of-1-bits/#/description
 
 191. Number of 1 Bits
 
 Write a function that takes an unsigned integer and 
 returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
so the function should return 3.


 
 */
package jz.Lintcode;

public class Numberof1Bits
{

    public static void main(String[] args)
    {
        System.out.println(hammingWeightII(11));

    }
     
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i = 0 ; i <= 31; i++)
        {
            if((n & 1) == 1) count++;
            n = n >>>1;
        }
        return count;
    }

    public static int hammingWeightII(int n) {
    	int count = 0 ; 
    	while(n != 0 ) {
    		count++;
    		n =  n & (n - 1);
    	}
    	return count;
    }
}
