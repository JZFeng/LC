package jz.Deprecated;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

//http://lintcode.com/en/problem/top-k-largest-numbers-ii/
public class TopkLargestNumbersII {

	/*
	 * @param k: An integer
	 */
	PriorityQueue<Integer> pq = null;
	int size = 0;

	public TopkLargestNumbersII(int k) {
		pq = new PriorityQueue<Integer>(k);
		this.size = k;
	}

	/*
	 * @param num: Number to be added
	 * 
	 * @return: nothing
	 */
	public void add(int num) {
		pq.offer(num);
		if (pq.size() > size) {
			pq.poll();
		}
	}

	/*
	 * @return: Top k element
	 */
	public List<Integer> topk() {

		List<Integer> res = new ArrayList<>();
		Iterator<Integer> itr = pq.iterator();
		while (itr.hasNext()) {
			res.add(itr.next());
		}

		Collections.sort(res, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});

		return res;
	}

}
