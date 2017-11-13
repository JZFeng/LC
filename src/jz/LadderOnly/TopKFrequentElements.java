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
package jz.LadderOnly;

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

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		List<Integer> res = topKFrequent(nums, 2);
		Iterator<Integer> itr = res.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

	}

	public static List<Integer> topKFrequent(int[] nums, int k) {

		// hashmap to store value and frequency
		HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
		for (int num : nums) {
			if (hashmap.containsKey(num))
				hashmap.put(num, hashmap.get(num) + 1);
			else
				hashmap.put(num, 1);
		}

		// build up minHeap and define the Comparator.内部匿名类
		PriorityQueue<Entry<Integer, Integer>> queue = new PriorityQueue<Entry<Integer, Integer>>(
				new Comparator<Entry<Integer, Integer>>() {
					public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
						return e1.getValue() - e2.getValue();
					}
				});

		// maintain size of queue as K
		for (Entry<Integer, Integer> entry : hashmap.entrySet()) {
			if (queue.size() < k)
				queue.offer(entry);
			else if (entry.getValue() > queue.peek().getValue()) {
				queue.poll();
				queue.offer(entry);
			}
		}

		// iterate the queue and get the result.Since order matters, we have to
		// use poll();
		List<Integer> res = new ArrayList<Integer>();

		while (!queue.isEmpty()) {
			Entry<Integer, Integer> e = queue.poll();
			res.add(e.getKey());
		}

		Collections.reverse(res);
		return res;

	}

}
