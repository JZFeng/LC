package jz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,8,9,10,7};
		System.out.print(kthSmallest(10, nums));
	}
	
	public static int kthSmallest(int k, int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		for(int num : nums) {
			pq.offer(num);
			if ( pq.size() > k) {
				pq.poll();
			}
		}
		
		return pq.peek();
		
	}
}
