/**
 https://leetcode.com/problems/valid-palindrome/#/description
 
 125. Valid Palindrome
 
 Given a string, determine if it is a palindrome, 
 considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

    Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 
 */
package jz.lc.easy;

/**
 * @author jzhfeng
 * @date May 21, 2017
 */
public class ValidPalindrome
{

    public static void main(String[] args)
    {
        System.out.println(isPalindrome("0P"));

    }

    public static boolean isPalindrome(String s)
    {
        if(s == null || s.length() <= 1)
            return true;
        
        s = s.toLowerCase();
        
        int i = 0 ; int j = s.length() -1;
        while(i < j)
        {
          //while loop and put the i < j condition too because when you do i++, i may >= j
            while(!isAlphanumeric(s.charAt(i)) && i <j) i++; 
            while(!isAlphanumeric(s.charAt(j)) && i <j) j--;
            if(s.charAt(i) != s.charAt(j)) return false;
            else
            {
                i++;
                j--;
            }
        }
    
        return true;

    }

    
    private static boolean isAlphanumeric(char c)
    {
        return ( c >= 'a' && c <= 'z') || ( c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
}
