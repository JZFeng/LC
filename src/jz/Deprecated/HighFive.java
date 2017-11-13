package jz.Deprecated;

//http://lintcode.com/en/problem/high-five/
import java.util.*;

public class HighFive {

	class Record {
		public int id, score;

		public Record(int id, int score) {
			this.id = id;
			this.score = score;
		}
	}

	public Map<Integer, Double> highFive(Record[] results) {
		// Write your code here
		HashMap<Integer, PriorityQueue<Integer>> hash = new HashMap<Integer, PriorityQueue<Integer>>();
		HashMap<Integer, Double> result = new HashMap<Integer, Double>();

		for (Record r : results) {
			if (!hash.containsKey(r.id)) {
				hash.put(r.id, new PriorityQueue<Integer>());
			}
			PriorityQueue temp = hash.get(r.id);
			temp.offer(r.score);
			if (temp.size() > 5) {
				temp.poll();
			}
		}
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
			int id = entry.getKey();
			PriorityQueue<Integer> temp = entry.getValue();
			int size = temp.size();
			double avg = 0;
			while (!temp.isEmpty()) {
				avg += temp.poll();
			}
			avg = avg / size;
			result.put(id, avg);
		}
		return result;
	}

}
