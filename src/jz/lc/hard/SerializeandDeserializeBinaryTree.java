/**
 https://leetcode.com/problems/serialize-and-deserialize-binary-tree/#/description
 
 297. Serialize and Deserialize Binary Tree
 
 Serialization is the process of converting a data structure or object into a sequence of bits 
 so that it can be stored in a file or memory buffer, 
 or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

 */
package jz.lc.hard;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import jz.BinarySearchTree.TreeNode;

/**
 * @author jzhfeng
 * @date May 15, 2017
 */
public class SerializeandDeserializeBinaryTree
{

    public static void main(String[] args)
    {
        String s = "5,4,7,3,#,2,#,-1,#,9";
        System.out.println(s);
        
        TreeNode treeNode  = createTreeNode(s);
        System.out.println(levelOrder(treeNode));


    }

    public static TreeNode createTreeNode(String str)
    {
        if (str == null)
        {
            return null;
        }

        String[] values = str.split(",");

        if (values.length <= 0)
        {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        int i = 1;
        while (i < values.length)
        {
            int count = queue.size();

            for (int m = 0; m < count; m++)
            {
                TreeNode node = queue.poll();

                if (!values[i].trim().equals("#"))
                {
                    TreeNode tmp = new TreeNode(Integer.valueOf(values[i].trim()));
                    node.left = tmp;
                    queue.add(tmp);
                }

                if (i + 1 < values.length && !values[i + 1].trim().equals("#"))
                {
                    TreeNode tmp = new TreeNode(Integer.valueOf(values[i + 1].trim()));
                    node.right = tmp;
                    queue.add(tmp);
                }

                i += 2;

                if (i >= values.length)
                {
                    break;
                }
            }
        }

        return root;
    }

    /*
     * 5 / \ 4 7 / / 3 2 / / -1 9
     * 
     * 5,4,7,3,null,2,null,-1,null,9
     * 
     */
    private static String levelOrder(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null)
            queue.offer(root);

        int nodesInCurrentLevel = 1;
        int nodesInNextLevel = 0;

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty())
        {
            TreeNode tmp = queue.poll();
            if (tmp.val == Integer.MIN_VALUE)
            {
                sb.append("#,");
            }
            else
            {
                sb.append(tmp.val + ",");
                nodesInCurrentLevel--;

                if (tmp.left != null || tmp.right != null)
                {
                    if (tmp.left != null)
                    {
                        queue.offer(tmp.left);
                    }
                    else
                    {
                        queue.offer(new TreeNode(Integer.MIN_VALUE));
                    }
                    nodesInNextLevel++;

                    if (tmp.right != null)
                    {
                        queue.offer(tmp.right);
                    }
                    else
                    {
                        queue.offer(new TreeNode(Integer.MIN_VALUE));
                    }
                    nodesInNextLevel++;
                }

            }

            if (nodesInCurrentLevel == 0)
            {
                nodesInCurrentLevel = nodesInNextLevel;
                nodesInNextLevel = 0;
            }
        }

        return removeCharactersFromTail(sb.toString());

    }

    private static String removeCharactersFromTail(String s)
    {
        s = s.trim();
        int j = s.length() - 1;
        while (s.charAt(j) == ',' || s.charAt(j) == '#')
            j--;
        return s.substring(0, j + 1);
    }

}
