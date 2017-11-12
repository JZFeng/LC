/*
 https://leetcode.com/problems/pascals-triangle/#/description
 118. Pascal's Triangle
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
] 
 */
package jz.Lintcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);list.add(1);
		System.out.println(list);
		list = getNextRow(list);
		System.out.println(list);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows <= 0)
			return null;

		List<Integer> origin = new ArrayList<Integer>();
		origin.add(1);
		res.add(origin);

		for (int i = 1; i < numRows; i++) {
			origin = getNextRow(origin);
			res.add(origin);
		}

		return res;

	}

	// [1,2,1] --> 1,3,3,1
	
	private static List<Integer> getNextRow(List<Integer> list) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for(int i = 1; i < list.size(); i++ ) {
			int tmp = list.get(i) + list.get(i - 1);
			res.add(tmp);
		}
		res.add(1);
		return res;
	}
}
