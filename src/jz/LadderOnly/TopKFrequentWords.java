package jz.LadderOnly;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//http://lintcode.com/en/problem/top-k-frequent-words/
public class TopKFrequentWords {

	/*
	 * @param words: an array of string
	 * 
	 * @param k: An integer
	 * 
	 * @return: an array of string
	 */
	public String[] topKFrequentWords(String[] words, int k) {
		if (words == null || words.length == 0 || k <= 0) {
			return new String[] {};
		}

		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(k,
				new Comparator<Map.Entry<String, Integer>>() {
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						if (e1.getValue() != e2.getValue()) {
							return e1.getValue() - e2.getValue();
						}

						return e2.getKey().compareToIgnoreCase(e1.getKey());

					}
				});

		for (Map.Entry<String, Integer> e : map.entrySet()) {
			pq.offer(e);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		String[] res = new String[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = pq.poll().getKey();
		}

		return res;
	}

}
