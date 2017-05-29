/**
https://leetcode.com/problems/implement-strstr/#/description

28. Implement strStr()

Implement strStr().

Returns the index of the first occurrence of needle in haystack,

or -1 if needle is not part of haystack.

 
 */
package jz.lc;

/**
 *@author jzhfeng
 *@date May 10, 2017
 */
public class ImplementstrStr
{

    public static void main(String[] args)
    {
        
        String haystack = "abababababcdabcdef";
        String needle = "abc";
        System.out.println(haystack.indexOf(needle));
        System.out.println(strStr(haystack, needle));

    }
    
    //Use two pointers. Every time when it does not match, reset j = 0; i = i - (j-1); 
    public static int strStr(String haystack, String needle) {
        
        int i = 0 ; int j = 0;
        
        while(i < haystack.length() && j < needle.length())
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                if(i == haystack.length()) return -1;
                i = i-j+1;
                j = 0;
            }
                
        }
        
        if(j == needle.length())
            return i-j;
        else
             return -1;
        
    }

}
