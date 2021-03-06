/*
 https://leetcode.com/problems/clone-graph/#/description
 Clone an undirected graph. 
 Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 
 */
package jz.Deprecated;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph {
	/**
	 * @param node:
	 *            A undirected graph node
	 * @return: A undirected graph node
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		// get all nodes
		ArrayList<UndirectedGraphNode> nodes = getAllNodes(node);

		// copy nodes;
		HashMap<UndirectedGraphNode, UndirectedGraphNode> hashmap = new HashMap<>();
		for (UndirectedGraphNode n : nodes) {
			hashmap.put(n, new UndirectedGraphNode(n.label));
		}

		// copy edges;
		for (UndirectedGraphNode n : nodes) {
			UndirectedGraphNode newNode = hashmap.get(n);
			for (UndirectedGraphNode neighbor : n.neighbors) {
				newNode.neighbors.add(hashmap.get(neighbor));
			}
		}

		return hashmap.get(node);
	}

	private ArrayList<UndirectedGraphNode> getAllNodes(UndirectedGraphNode node) {
		Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		HashSet<UndirectedGraphNode> set = new HashSet<>();
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode head = queue.poll();
			set.add(head);
			for (UndirectedGraphNode neighbor : head.neighbors) {
				if (set.add(neighbor) == true) {
					queue.offer(neighbor);
				}
			}
		}

		return new ArrayList<UndirectedGraphNode>(set);
	}

}
