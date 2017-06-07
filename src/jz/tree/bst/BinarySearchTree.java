package jz.tree.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class BinarySearchTree {
    
    public static void main(String[] args) {

       TreeNode root = TreeNode.fromString("1,2,3,4,5,6,7");
       BinarySearchTree bst = new BinarySearchTree(root);
       
       bst.postOrder();
       System.out.println();
       
       ArrayList<Integer> arraylist =  (ArrayList<Integer>) bst.preorderTraversal(root);
       Iterator<Integer> itr = arraylist.iterator();
       while(itr.hasNext()){
           System.out.print(itr.next() + " ");
       }

    }

    
	TreeNode root;

    public static List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushAllLeftNodes(root, stack);
        List<Integer> res = new ArrayList<Integer>();
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            pushAllLeftNodes(cur.right, stack);
        }
        
        return res;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root != null)
            stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        
        return res;
    }

    
    private static void pushAllLeftNodes(TreeNode root, Stack<TreeNode> stack){
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }
    
	
	public BinarySearchTree() {
		this.root = null;
	}

    public BinarySearchTree(int val)
    {
        this.root = new TreeNode(val);
    }
    
    public BinarySearchTree(TreeNode root)
    {
        this.root = root;
    }

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val + " ");
			inOrder(root.right);
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
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
			System.out.print(root.val + " ");
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
			System.out.print(tmp.val + " ");
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
			System.out.print(tmp.val + " ");

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
			System.out.print(tmp.val + " ");
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

		else if (key < t.val)
			t.left = insert(key, t.left);
		else if (key > t.val)
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
		
		if(key < root.val)
			root.left = remove(key, root.left);
		else if (key > root.val)
			root.right = remove(key, root.right);
		else
		{
			if((root.left != null) && (root.right != null))
			{
				TreeNode tmp = findMax(root.left);
				root.val = tmp.val;
				root.left = remove(tmp.val, root.left);
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
		else if (x < t.val)
			return find(x, t.left);
		else if (x > t.val)
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



}
