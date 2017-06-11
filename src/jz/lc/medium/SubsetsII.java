/**
https://leetcode.com/problems/subsets-ii/#/description

90. Subsets II

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */

/**
 *@author jzhfeng
 *@date May 10, 2017
 */
package jz.lc.medium;
import java.util.ArrayList;
import java.util.Arrays;


public class SubsetsII
{

    public static void main(String[] args)
    {
    	int[] nums = new int[]{1,2,2};
    	ArrayList<ArrayList<Integer>>  results = subsetsWithDup(nums);
    	for(ArrayList<Integer> list : results){
    		System.out.println(list);
    	}
    	

    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums)
    {
    	ArrayList<ArrayList<Integer>> results = new ArrayList<>();

    	if(nums == null){
    		return results;
    	}
    	if(nums.length == 0){
    		results.add(new ArrayList<Integer>());
    		return results;
    	}
    	
    	Arrays.sort(nums);
    	ArrayList<Integer> subset = new ArrayList<Integer>();
    	helper(nums, 0 , subset, results);

    	return results;
    	
    }

    private static void helper(int[] nums, int start, ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> res){
    	ArrayList<Integer> tmp = new ArrayList<Integer>(subset);
    	res.add(tmp);
    	
    	for(int i = start; i < nums.length; i++){
    	    if(i != start && nums[i] == nums[i -1] ){
    			continue;
    		}
    		tmp.add(nums[i]);
    		helper(nums, i + 1, tmp, res);
    		tmp.remove(tmp.size() -1 );
    	}
    	
    }
    
}
