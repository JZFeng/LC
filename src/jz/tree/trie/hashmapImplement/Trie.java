package jz.tree.trie.hashmapImplement;

import java.util.*;

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

	public List<String> findNWordsByPrefix(String prefix, int n) {

        TrieNode node = findNodeByPrefix(prefix);
        List<String> words = getAllWords(node);
        if(words.size() >= n) {
            //words = words.get(0, n - 1);
        } else {
            int count = n - words.size();

        }



        return words;

	}


	public TrieNode findNodeByPrefix(String prefix) {
		TrieNode cur = root;
		HashMap<Character, TrieNode> children = cur.children;
		char[] data = prefix.toLowerCase().toCharArray();
		int i = 0;
		for (; i < data.length; i++) {
			char c = data[i];
			if (!children.containsKey(c)) {
				return null;
			}
			cur = children.get(c);
			children = cur.children;
		}

		return (i == data.length) ? cur : null;

	}

	public List<String> getAllWords(TrieNode root) {
	    if(root == null  || root.val == ' ') {
            return new ArrayList<>();
        }
        if(root.isLeaf) {
            List<String> res = new ArrayList<>();
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> allWords = new ArrayList<>();
        TrieNode cur = root;
        HashMap<Character, TrieNode> children = cur.children;
        for(int i = 0 ; i < children.size(); i++) {
            allWords.add(String.valueOf(root.val));
        }
        for(Map.Entry<Character, TrieNode> entry : children.entrySet()) {
//          entry.getKey() + getAllWords(entry.getValue())
        }
        for(int i = 0 ; i < allWords.size(); i++) {
//

        }

		return allWords;

	}

}
