package jz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import jz.BinarySearchTree.TreeNode;
import jz.DoubleLinkedList.ListNode;

public class HelloWorld {
    
    public static class Pair implements Comparable<Pair>{
        int val;
        int freq;
        
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }

        public int compareTo(Pair o)
        {
            return this.freq - o.freq;
        }
        
    }

	public static void main(String[] args) {
	    Pair[] pairs = new Pair[] {new Pair(3,2),new Pair(5,1),new Pair(8,3), new Pair(12,5) , new Pair(11, 4)};
	    
	    //build up minHeap;
	    PriorityQueue<Pair> queue = new PriorityQueue<Pair>(3);
	    for(Pair p: pairs)
	    {
	        if(queue.size() < 3)
	            queue.offer(p);
	        else if(queue.peek().freq < p.freq){
	            queue.poll();
	            queue.offer(p);
	        }
	    }
	  
	    for(Pair p: queue){
	        System.out.println("Number: " + p.val + " ; " + p.freq);
	    }
	    
	    while(!queue.isEmpty()){
	       Pair p = queue.poll();
	       System.out.println("Number: " + p.val + " ; " + p.freq);
	   }
	    
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
