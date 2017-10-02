package jz.UnionFind;

import java.util.HashMap;
import java.util.HashSet;

public class UnionFind {

	HashMap<Integer, Integer> map = new HashMap<>();

	UnionFind(HashSet<Integer> hashSet) {
		for (Integer num : hashSet) {
			map.put(num, num);
		}
	}

	// return the parent
	public int find(int x) {
		int parent = map.get(x);
		while (parent != map.get(parent)) {
			parent = map.get(parent);
		}

		return parent;
	}

	public int compress_find(int x) {
		int parent = map.get(x);
		while (parent != map.get(parent)) {
			parent = map.get(parent);
		}
		// 更新路径上的所有子节点，让他们直接指向最终的父亲节点

		while (x != map.get(x)) {
			int next = map.get(x);
			map.put(x, parent);
			x = next;
		}

		return parent;
	}

	public void union(int x, int y) {
		int parent_x = find(x);
		int parent_y = find(y);
		if (parent_x != parent_y) {
			map.put(parent_x, parent_y);
		}

	}

}
