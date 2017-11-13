package jz.LadderOnly;

import java.util.PriorityQueue;

//http://lintcode.com/en/problem/kth-largest-element-ii/
public class KthLargestElementII {

	public int kthLargestElement2(int[] nums, int k) {
		// write your code here
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i : nums) {
			pq.offer(i);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.poll();
	}

}
