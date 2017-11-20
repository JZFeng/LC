package jz.tree.trie.arrayImplment;

class TrieNode {
	// Initialize your data structure here.
	char value;
	TrieNode[] children = new TrieNode[26];
	boolean isLeaf;

	public TrieNode(char c) {
		this.value = c;
		this.isLeaf = false;
	}
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void insert(String word) {

		char[] data = word.toLowerCase().toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 'a';
			if (cur.children[index] == null) {
				cur.children[index] = new TrieNode(data[i]);
			}
			cur = cur.children[index];
		}
		cur.isLeaf = true;
	}

	public boolean search(String word) {
		char[] data = word.toLowerCase().toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 'a';
			if (cur.children[index] == null) {
				return false;
			}
			cur = cur.children[index];
		}

		return cur.isLeaf;
	}

	public boolean startsWith(String prefix) {
		char[] data = prefix.toLowerCase().toCharArray();
		TrieNode cur = root;
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 'a';
			if (cur.children[index] == null) {
				return false;
			}
			cur = cur.children[index];
		}

		return true;

	}
}