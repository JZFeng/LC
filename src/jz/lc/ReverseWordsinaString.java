/**
https://leetcode.com/problems/reverse-words-in-a-string/#/description

151. Reverse Words in a String

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".
 */
package jz.lc;

import java.util.LinkedList;
import java.util.Stack;

/**
 *@author jzhfeng
 *@date May 21, 2017
 */
public class ReverseWordsinaString
{

    public static void main(String[] args)
    {
      String s = "   The     Sky    is   blue    ";
      System.out.println(reverseWordsIII(s));

    }
    
    
    
    //String[] strs = s.trim().split("\\s{1,} ");  this is important.
    
    public static String reverseWordsIII(String s)
    {
        if(s == null) return null;
        String[] strs = s.trim().split("\\s{1,} ");
        
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >=0 ; i--)
        {
                sb.append(strs[i] + " ");
        }
        
        return sb.toString().trim();
                
    }
    
    
    public static String reverseWords(String s)
    {
        if(s == null) return null;
        s = reverse(s.trim());
        
        char[] c = s.toCharArray();
        int i = 0 ; int j = c.length - 1;
        while(i < j)
        {
            char tmp = c[i];
            c[i] = c[j];
            c[j] = tmp;
            i++;
            j--;
        }
        
        return String.valueOf(c);
    }
    
    private static String reverse(String s)
    {
        if(s == null)
             return null;
        
        String[] strs = s.trim().split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(String str: strs)
        {
            if(str.trim().length() > 0 )
            {
                char[] c = str.toCharArray();
                int i = 0; int j = c.length -1;
                while(i < j)
                {
                    char tmp = c[i];
                    c[i] = c[j];
                    c[j] = tmp;
                    i++;
                    j--;
                }
                sb.append(String.valueOf(c)+" ");
            }
        }
            
        return sb.toString().trim();
    }
    
    
    public static String reveseWordsinString(String s)
    {
        if(s == null) return null;
        String[] strs = s.trim().split(" ");
        LinkedList<String> stack = new LinkedList<String>();
        for(String str: strs)
        {
            if(str.trim().length() > 0)
            {
                stack.push(str);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop()+" ");
        }
        
        return sb.toString().trim();

    }
    
}
