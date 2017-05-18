package jz.BinarySearchTree;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BinarySearchTree {

	TreeNode root;

	public BinarySearchTree(int key) {
		this.root = new TreeNode(key);
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.key + " ");
			inOrder(root.right);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.key + " ");
		}

	}

	public void levelOrder() {
		levelOrder2(root);
	}

	private void levelOrder(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null)
			queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			System.out.print(tmp.key + " ");
			if (tmp.left != null)
				queue.offer(tmp.left);
			if (tmp.right != null)
				queue.offer(tmp.right);
		}

	}

	private void levelOrder1(TreeNode root) {
		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		if (root != null)
			currentLevel.offer(root);

		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

		while (!currentLevel.isEmpty()) {
			TreeNode tmp = currentLevel.poll();
			System.out.print(tmp.key + " ");

			if (tmp.left != null)
				nextLevel.offer(tmp.left);
			if (tmp.right != null)
				nextLevel.offer(tmp.right);

			if (currentLevel.isEmpty()) {
				System.out.println();
				currentLevel = nextLevel;
				nextLevel = new LinkedList<TreeNode>();
			}
		}
	}

	private void levelOrder2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root != null)
			queue.offer(root);
		
		int nodesInCurrentLevel = 1;
		int nodesInNextLevel = 0;
		
		while(!queue.isEmpty())
		{
			TreeNode tmp = queue.poll();
			System.out.print(tmp.key + " ");
			nodesInCurrentLevel--;
			
			if(tmp.left != null)
			{
				queue.offer(tmp.left);
				nodesInNextLevel++;
			}
			if(tmp.right != null)
			{
				queue.offer(tmp.right);
				nodesInNextLevel++;
			}
			
			if(nodesInCurrentLevel == 0)
			{
				System.out.println();
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}
		}
		
		
	}

	public int size() {
		return size(root);
	}

	private int size(TreeNode root) {
		int i = 0;
		if (root == null)
			return i;
		else {
			i = size(root.left) + size(root.right) + 1;
		}

		return i;

	}

	public int height() {
		return height(root);
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		else
			return Math.max(height(root.left), height(root.right)) + 1;
	}

	public TreeNode insert(int key) {
		return insert(key, root);
	}

	private TreeNode insert(int key, TreeNode t) {
		if (t == null)
			return new TreeNode(key);

		else if (key < t.key)
			t.left = insert(key, t.left);
		else if (key > t.key)
			t.right = insert(key, t.right);

		return t;

	}
	
	
	public TreeNode remove(int key)
	{
		return remove(key,root);
	}
	
	private TreeNode remove(int key, TreeNode root)
	{
		if(root == null)
			return null;
		
		if(key < root.key)
			root.left = remove(key, root.left);
		else if (key > root.key)
			root.right = remove(key, root.right);
		else
		{
			if((root.left != null) && (root.right != null))
			{
				TreeNode tmp = findMax(root.left);
				root.key = tmp.key;
				root.left = remove(tmp.key, root.left);
			}
			else
			{
				return (root.left != null)? root.left:root.right;
			}
		}
		
		return root;
	}

	public TreeNode findMax() {
		return findMax(root);
	}

	private TreeNode findMax(TreeNode t) {
		if (t == null)
			return null;

		while (t.right != null) {
			t = t.right;
		}

		return t;

	}

	public TreeNode findMin() {
		return findMin(root);
	}

	private TreeNode findMin(TreeNode t) {
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		else
			return findMin(t.left);

	}

	public TreeNode find(int x, TreeNode t) {
		if (t == null)
			return null;
		else if (x < t.key)
			return find(x, t.left);
		else if (x > t.key)
			return find(x, t.right);
		else
			return t;

	}
	
	public boolean contains(int x)
	{
		return (find(x, root) == null)?true:false;
	}

	public static HashSet<Integer> RandomSet(int min, int max, int size) {
		if ((min > max) || (size <= 0))
			return null;

		HashSet<Integer> set = new HashSet<Integer>();
		Random rd = new Random();
		while (set.size() < size) {
			set.add(rd.nextInt(max - min + 1) + min);
		}

		return set;

	}

	public static void main(String[] args) {

		System.out.println(Integer.toBinaryString(-2));
		System.out.println(Integer.toBinaryString(-3));
		int i = (int)'A';
		System.out.println(Integer.toBinaryString(~'A'));

	}

}
