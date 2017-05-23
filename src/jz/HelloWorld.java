package jz;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import jz.BinarySearchTree.TreeNode;
import jz.DoubleLinkedList.ListNode;

public class HelloWorld {

	public static void main(String[] args) {
	    String s = "   2    5    6 7     4       8      9     3     1    0   ";
	    String[] nums = s.trim().split("\\s{1,}");
	    for(String num: nums)
	        System.out.print(Integer.parseInt(num)+" ");
	}
	

	 
}
