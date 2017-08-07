/**
 https://leetcode.com/problems/longest-common-prefix/#/description
 
 Write a function to find the longest common prefix string amongst an array of strings.
 */
package jz.lc.medium;

/**
 * @author jzhfeng
 * @date May 10, 2017
 */
public class LongestCommonPrefix
{

    public static void main(String[] args)
    {
        String[] strs ={"abcd","abc","abce", "abcdef"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int i = 1 ; i < strs.length ; i++)
        {
            prefix = commonPrefix(prefix, strs[i]);
        }

        return prefix;
    }

    private static String commonPrefix(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++)
        {
            if (s1.charAt(i) == s2.charAt(i))
                sb.append(s1.charAt(i));
            else
                break;
        }
        return sb.toString().trim();
    }

    private static int maxLen(String[] strs)
    {
        int count = 0;
        for (String str : strs)
        {
            if (str.length() > count)
                count = str.length();
        }
        return count;
    }

    private static int minLen(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return -1;
        int count = strs[0].length();
        for (int i = 1; i < strs.length; i++)
        {
            if (strs[i].length() < count)
                count = strs[i].length();
        }
        return count;
    }

    private static String minLenString(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++)
        {
            if (strs[i].length() < result.length())
                result = strs[i];
        }
        return result;
    }

    private static int minLenIndex(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return -1;
        int result = 0;
        for (int i = 1; i < strs.length; i++)
        {
            if (strs[i].length() < strs[result].length())
                result = i;
        }
        return result;
    }
}
