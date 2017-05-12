/**
 https://leetcode.com/problems/first-unique-character-in-a-string/#/description
 387. First Unique Character in a String
 Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */

package jz.lc.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *@author jzhfeng
 *@date May 12, 2017
*/
public class FirstUniqueCharacterinaString
{

    public static void main(String[] args)
    {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
        
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(s.indexOf(c) == s.lastIndexOf(c))
            {
                System.out.println(i);
                break;
                
            }
               
            
            
        }

    }
    
    public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0)
            return -1;
        if(s.length() <=2)
            return 0;
            
        HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
        int res = 0;
        hashmap.put(s.charAt(0), 1);
        
        for(int i = 1 ; i < s.length() ; i++)
        {
            Character c = Character.valueOf(s.charAt(i));
            if(hashmap.containsKey(c))
                hashmap.replace(c, (hashmap.get(c).intValue()+1));
            else
            {
                hashmap.put(c, 1);
            }
                
        }
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            Character c = Character.valueOf(s.charAt(i));
            int tmp = hashmap.get(c).intValue();
            if( tmp == 1)
                return i; 
           
            
        }
        
        return -1;
        
    }

}
