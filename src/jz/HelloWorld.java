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
        int[] a = new int[]
        { 0, 0, 0, 1, 3, 12, 0, 0 };
        Util.printArray(a);
        moveZeroes(a);
        Util.printArray(a);

	 
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

	   public static void moveZeroes(int[] a)
	    {
	        if (a == null || a.length < 2)
	            return;

	        int i = 0;
	        int j = 0;

	        while (j < a.length)
	        {
	            if ((a[i] != 0))
	                i++;
	            if (a[j] == 0)
	                j++;
	            if (i < j)
	            {
	                Util.swap(a, i, j);
	                j++;
	            }
	            else
	            {
	                j++;
	            }

	        }

	    }

}
