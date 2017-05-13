/**
 *
https://leetcode.com/problems/reverse-string/#/description

344. Reverse String

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Subscribe to see which companies asked this question.
 */
package jz.lc.easy;

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
        if (s == null)
            return null;
        if (s.length() <= 1)
            return s;

        char[] str = s.trim().toCharArray();

        int j = str.length - 1;
        int i = 0;
        while (i < j)
        {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            i++;
            j--;
        }

        return String.valueOf(str);

    }

}
