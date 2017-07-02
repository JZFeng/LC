package jz.lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import jz.tree.bst.TreeNode;

public class BinaryTreeSerialization {

	public static void main(String[] args) {
		String s = "{3,9,20,#,#,15,7}";
		TreeNode newRoot = deserialize(s);
		HashSet<Integer> set = new HashSet<>();
		for (Integer i : set ) {
			System.out.println(i);
		}
	}

	public static String serialize(TreeNode root) {
		// write your code here
		if (root == null) {
			return "{}";
		}

		ArrayList<TreeNode> allNodes = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			allNodes.add(tmp);
			allNodes.add(tmp.left);
			allNodes.add(tmp.right);

			if (tmp.left != null) {
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
		}

		while (allNodes.get(allNodes.size() - 1) == null) {
			allNodes.remove(allNodes.size() - 1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(allNodes.get(0).val);
		for (int i = 1; i < allNodes.size(); i++) {
			sb.append("," + allNodes.get(i).val);
		}
		sb.append("}");

		return sb.toString();
	}

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
	public static TreeNode deserialize(String data) {
		// write your code here
		if (data == null) {
			return null;
		}

		String str = data.trim();
		if (str.startsWith("{") || str.startsWith("[")) {
			str = str.substring(1, str.length() - 1);
		}
		if (str.equals("")) {
			return null;
		}

		String[] strs = str.split(",");
		if (strs.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		for (int i = 1; i < strs.length; i = i + 2) {
			if (!queue.isEmpty()) {
				TreeNode tmp = queue.poll();
				if (!strs[i].equals("#")) {
					tmp.left = new TreeNode(Integer.parseInt(strs[i]));
					queue.offer(tmp.left);
				}
				if (i + 1 < strs.length && !strs[i + 1].equals("#")) {
					tmp.right = new TreeNode(Integer.parseInt(strs[i + 1]));
					queue.offer(tmp.right);
				}

			}
		}

		return root;
	}

}
