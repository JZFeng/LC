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
package jz.lc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = generate(1);

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (numRows <= 0)
			return null;

		ArrayList<Integer> origin = new ArrayList<Integer>();
		origin.add(1);
		res.add(origin);

		for (int i = 1; i < numRows; i++) {
			origin = helper(origin);
			res.add(origin);
		}

		return res;

	}

	// [1,2,1] --> 1,3,3,1
	private static ArrayList<Integer> helper(ArrayList<Integer> a) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0;
		for (; i < a.size(); i++) {
			if (i == 0)
				res.add(a.get(i));
			else {
				res.add(a.get(i) + a.get(i - 1));
			}
		}
		res.add(a.get(i - 1));
		return res;
	}

}
