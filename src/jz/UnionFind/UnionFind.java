package jz.UnionFind;

import java.util.HashMap;
import java.util.HashSet;

public class UnionFind {

	HashMap<Integer, Integer> father = new HashMap<>();

	UnionFind(HashSet<Integer> hashSet) {
		for (Integer num : hashSet) {
			father.put(num, num);
		}
	}

	// return the parent
	public int find(int x) {
		int parent = father.get(x);
		while (parent != father.get(parent)) {
			parent = father.get(parent);
		}

		return parent;
	}

	public int compress_find(int x) {
		int parent = father.get(x);
		while (parent != father.get(parent)) {
			parent = father.get(parent);
		}
		// 更新路径上的所有子节点，让他们直接指向最终的父亲节点

		while (x != father.get(x)) {
			int next = father.get(x);
			father.put(x, parent);
			x = next;
		}

		return parent;
	}

	public void union(int x, int y) {
		int parent_x = find(x);
		int parent_y = find(y);
		if (parent_x != parent_y) {
			father.put(parent_x, parent_y);
		}

	}

}
