/*
 http://www.lintcode.com/en/problem/permutations/
  
 */
package jz.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> ans = permute(nums);
		for(List<Integer> a : ans){
			System.out.println(a);
		}

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if(nums == null ){
			return ans;
		}
		if(nums.length == 0){
			ans.add(new ArrayList<Integer>());
			return ans;
		}
		
		Arrays.sort(nums);
		int[] isVisited = new int[nums.length];
		ArrayList<Integer> subset = new ArrayList<>();
		permuteHelper(nums, subset, isVisited, ans );
		return ans;
	}
	
	private static void permuteHelper(int[] nums, 
									 ArrayList<Integer> subset, 
									 int[] isVisited, 
									 List<List<Integer>>ans){
		ArrayList<Integer> tmp = new ArrayList<>(subset);
		if(subset.size() == nums.length){
			ans.add(tmp);
		}
		
		for(int i = 0 ; i < nums.length; i++){
			if(isVisited[i] == 1){
				continue;
			}
			isVisited[i] = 1;
			tmp.add(nums[i]);
			permuteHelper(nums, tmp, isVisited, ans);
			tmp.remove(tmp.size() -1);
			isVisited[i] = 0;
		}
		
	}
	
}
