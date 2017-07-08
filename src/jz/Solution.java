package jz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import jz.DoubleLinkedList.ListNode;
import jz.tree.bst.TreeNode;

public class HelloWorld {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2,2,2,3,3,4 };
		int pos = removeDuplicateNumbers(nums);
		for(int i = 0 ; i < pos; i++ ){
			System.out.print(nums[i] + " ");
		}

	}
	
	private static int removeDuplicateNumbers(int[] nums){
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int pos =1;
		for(int i = 1 ; i < nums.length; i++){
			if(nums[i] == nums[i -1]){
				continue;
			}
			else{
				swap(nums, i, pos);
				pos++;
			}
	
		}
		
		return pos;
	}
	
	private static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
    public int backPack(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if(f[i-1][j] == true || (j >= A[i-1] && f[i-1][j - A[i-1]]) ){
	                f[i][j] = true;
                } else{
	                f[i][j] = false;
                } // for j
            }   
        } // for i
        
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        
        return 0;
    }

	public static int[] mergeSortedArray(int[] A, int[] B) {
		if (A == null || B == null) {
			return (A == null) ? B : A;
		}
		if (A.length == 0 || B.length == 0) {
			return (A.length == 0) ? B : A;
		}

		int[] res = new int[A.length + B.length];
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < A.length && j < B.length) {
			if (A[i] > B[j]) {
				res[index++] = B[j++];
			} else {
				res[index++] = A[i++];
			}
		}

		while (i < A.length) {
			res[index++] = A[i++];
		}

		while (j < B.length)
			res[index++] = B[j++];
		
		return res;
	}


	public static int findMin(int[] nums) {
		if (nums[0] <= nums[nums.length - 1]) {
			return nums[0];
		}

		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= nums[start]) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (nums[start] > nums[end]) {
			return nums[end];
		} else {
			return nums[start];
		}

	}

	public static int findPeakElement(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > nums[mid - 1]) {
				start = mid;
			} else if (nums[mid] < nums[mid + 1]) {
				end = mid;
			} else {
				end = mid;
			}
		}

		if (nums[start] < nums[end]) {
			return end;
		} else {
			return start;
		}

	}

	public int findPeak(int[] A) {
		// write your code here
		int start = 1, end = A.length - 2; // 1.答案在之间，2.不会出界
		while (start + 1 < end) {
			int mid = (start + end) / 2;
			if (A[mid] < A[mid - 1]) {
				end = mid;
			} else if (A[mid] < A[mid + 1]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (A[start] < A[end]) {
			return end;
		} else {
			return start;
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start) {
		ans.add(new ArrayList<Integer>(tempList));

		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(ans, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
}
