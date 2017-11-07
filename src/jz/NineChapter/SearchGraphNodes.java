package jz.NineChapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//http://lintcode.com/en/problem/search-graph-nodes/

public class SearchGraphNodes {

	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
			Map<UndirectedGraphNode, Integer> values, UndirectedGraphNode node, int target) {
		if (node == null) {
			return null;
		}

		UndirectedGraphNode res = null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
		queue.offer(node);
		set.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode tmp = queue.poll();
			if (values.get(tmp).intValue() == target) {
				res = tmp;
				break;
			}

			for (UndirectedGraphNode n : tmp.neighbors) {
				if (!set.contains(n)) {
					queue.offer(n);
					set.add(n);
				}
			}
		}

		return res;

	}

}
