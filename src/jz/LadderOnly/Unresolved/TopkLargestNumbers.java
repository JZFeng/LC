package jz.LadderOnly.Unresolved;

import java.util.PriorityQueue;

//http://lintcode.com/en/problem/top-k-largest-numbers/
public class TopkLargestNumbers {

	public int[] topk(int[] nums, int k) {
		int[] res = new int[k];
		if (nums == null || nums.length == 0) {
			return res;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		int index = k - 1;
		while (!pq.isEmpty()) {
			res[index--] = pq.poll();
		}

		return res;
	}

}
