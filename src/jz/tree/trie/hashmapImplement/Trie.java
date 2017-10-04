package jz.tree.trie.hashmapImplement;

import java.util.HashMap;

class TrieNode {
    char val;
    HashMap<Character, TrieNode> children = null;
    boolean isLeaf;

    TrieNode(char val) {
	this.val = val;
	this.children = new HashMap<Character, TrieNode>();
	this.isLeaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public static void main(String[] args) {
	Trie trie = new Trie();
	trie.insert("lintcode");;
	trie.insert("word");;
	System.out.println(trie.search("word"));
	System.out.println(trie.startsWith("lint"));
    }
    
    Trie() {
	this.root = new TrieNode(' ');
    }

    public void insert(String word) {
	char[] data = word.toLowerCase().toCharArray();
	TrieNode cur = root;
	HashMap<Character, TrieNode> children = cur.children;
	for (int i = 0; i < data.length; i++) {
	    char c = data[i];
	    if (!children.containsKey(c)) {
		TrieNode node = new TrieNode(c);
		children.put(c, node);
	    }
	    cur = children.get(c);
	    children = cur.children;
	}
	cur.isLeaf = true;
    }

    public boolean search(String word) {
	TrieNode cur = root;
	HashMap<Character, TrieNode> children = cur.children;

	char[] data = word.toLowerCase().toCharArray();
	for (int i = 0; i < data.length; i++) {
	    char c = data[i];
	    if (!children.containsKey(c)) {
		return false;
	    }
	    cur = children.get(c);
	    children = cur.children;
	}

	return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
	TrieNode cur = root;
	HashMap<Character, TrieNode> children = cur.children;
	char[] data = prefix.toLowerCase().toCharArray();
	for (int i = 0; i < data.length; i++) {
	    char c = data[i];
	    if (!children.containsKey(c)) {
		return false;
	    }
	    cur = children.get(c);
	    children = cur.children;
	}

	return true;
    }
}
