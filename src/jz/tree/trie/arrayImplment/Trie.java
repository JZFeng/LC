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

    public static void main(String[] args) {
	Trie trie = new Trie();
	trie.insert("lintcode");
	trie.insert("word");
	System.out.println(trie.search("Word"));
	System.out.println(trie.startsWith("lint"));
    }
    
    public Trie() {
	// do intialization if necessary
	root = new TrieNode(' ');
    }

    /*
     * @param word: a word
     * 
     * @return: nothing
     */
    public void insert(String word) {
	// write your code here
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

    /*
     * @param word: A string
     * 
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
	// write your code here
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

    /*
     * @param prefix: A string
     * 
     * @return: if there is any word in the trie that starts with the given
     * prefix.
     */
    public boolean startsWith(String prefix) {
	// write your code here
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