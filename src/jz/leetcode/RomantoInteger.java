/*
https://leetcode.com/problems/roman-to-integer/#/description

13. Roman to Integer
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 */

package jz.leetcode;

public class RomantoInteger
{

    public static void main(String[] args)
    {
        System.out.println(romanToInt("DCCCXII"));

    }

    public static int romanToInt(String s)
    {
        int res = ctoi(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--)
        {
            if (ctoi(s.charAt(i)) >= ctoi(s.charAt(i + 1)))
                res += ctoi(s.charAt(i));
            else
                res -= ctoi(s.charAt(i));
        }
        return res;
    }

    private static int ctoi(char c)
    {
        switch (c)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;

            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;

            default:
                return -1;
        }
    }
}
