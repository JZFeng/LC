/**
 https://leetcode.com/problems/excel-sheet-column-number/#/description
 
 171. Excel Sheet Column Number
 
 Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 
 */
package jz.Lintcode;

/**
 * @author jzhfeng
 * @date May 20, 2017
 */
public class ExcelSheetColumnNumber
{

    public static void main(String[] args)
    {
        String s = "AB";
        System.out.println(titleToNumber(s));

    }

    public static int titleToNumber(String s)
    {
        if(s == null || s.length() == 0)
            return -1;
        s = s.trim().toUpperCase();
        
        int result = 0;
        for(int i = 0 ; i < s.length(); i++)
        {
            result = result * 26 + chartoInt(s.charAt(i));
        }
        
        return result;
    }
    
    private static int chartoInt(char c)
    {
        return c - 'A'+1;
    }

}
