/*
 215. Kth Largest Element in an Array
 https://leetcode.com/problems/kth-largest-element-in-an-array/#/description
  
 */
package jz.lc.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] { 9, 3, 2, 4, 8 };
		System.out.println(findKthSmallest(nums, 2));

	}

	public static int findKthSmallest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2 ) {
				return o1 - o2;
			}
		});
		
		for (int num : nums) {
			if (pq.size() < k) {
				pq.offer(num);
			} else {
				if (num > pq.peek()) {
					pq.poll();
					pq.offer(num);
				}
			}
		}

		return pq.peek();

	}

}
