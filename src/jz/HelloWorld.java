package jz;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import jz.BinarySearchTree.TreeNode;
import jz.DoubleLinkedList.ListNode;

public class HelloWorld {

	public static void main(String[] args) {
	    String s = "312211";
	    System.out.println(helper(s));
	 
	}
	
	//"1","11","111221", "312211"
    private static String helper(String s)
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0 ;
        for(; i < s.length(); i++)
        {
            if(i == 0) count++;
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
    
	
	public static String removeExcessWhileSpace(String s)
	{
	    if(s == null || s.length() ==0)
	        return null;
	    s = s.trim();
	    //s = "   2    5    6 7     4       8      9     3     1    0   ";
	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    for(;i < s.length()-1; i++)
	    {
	        if(s.charAt(i) ==  ' ' && s.charAt(i+1) == ' ')
	            continue;
	        else
	            sb.append(s.charAt(i));
	    }
	    sb.append(s.charAt(i));
	    return sb.toString().trim();
	}

	
}
