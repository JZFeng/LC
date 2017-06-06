/**
 https://leetcode.com/problems/count-and-say/#/description
 
 38. Count and Say
 
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 
 
 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class CountAndSay
{
    public static void main(String[] args)
    {
        System.out.println(countAndSay(5));
    }
    
    public static String countAndSay(int n) {
        String prefix = "1";
        for(int i = 1 ; i <= n; i++)
        {
            prefix = helper(prefix);
        }
        return prefix;
    }
    
    //"11","111221","312211"
    private static String helper(String s)
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for( ; i < s.length(); i++)
        {
            if(i == 0 ) count++;
            else if(s.charAt(i) == s.charAt(i-1)) count++;
            else
            {
                sb.append(count);
                sb.append(s.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(i-1));
        return sb.toString();
        
    }

}
