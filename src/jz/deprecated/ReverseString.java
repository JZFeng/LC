/**
 *
https://leetcode.com/problems/reverse-string/#/description

344. Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Subscribe to see which companies asked this question.
 */
package jz.deprecated;

/**
 * @author jzhfeng
 * @date May 12, 2017
 */
public class ReverseString
{

    public static void main(String[] args)
    {
        System.out.println(reverseString("Hello World"));

    }

    public static String reverseString(String s)
    {
        if(s == null || s.length() == 1)
            return s;
        
        int i = 0 ; int j = s.length() -1;
        char[] c = s.toCharArray();
        while(i <j)
        {
            swap(c, i, j);
            i++;
            j--;
        }
       
        return String.valueOf(c);
        
    }
    
    private static void swap(char[] c, int i , int j)
    {
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
    }

}
