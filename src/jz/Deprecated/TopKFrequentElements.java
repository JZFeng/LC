/*
 https://leetcode.com/problems/top-k-frequent-elements/#/description
 
 347. Top K Frequent Elements
 
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
  
 */
package jz.Deprecated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k,
				new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
						int diff = e1.getValue() - e2.getValue();
						if (diff == 0) {
							diff = e1.getKey() - e2.getKey();
						}

						return diff;
					}
				});

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			pq.offer(e);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		while (!pq.isEmpty()) {
			res.add(0, pq.poll().getKey());
		}

		return res;
	}
}
