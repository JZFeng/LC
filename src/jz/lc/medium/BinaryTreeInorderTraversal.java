/*
 https://leetcode.com/problems/binary-tree-inorder-traversal/#/description
 
 94. Binary Tree Inorder Traversal
 
 Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


  
 */
package jz.lc.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import jz.BinarySearchTree.BinarySearchTree;
import jz.BinarySearchTree.TreeNode;
import jz.LinkedList.ListNode;

public class BinaryTreeInorderTraversal
{

    public static void main(String[] args)
    {
        TreeNode root = TreeNode.fromString("1,2,3,4,5,6,7");
        BinarySearchTree bst = new BinarySearchTree(root);
        bst.inOrder();
        System.out.println();
        
        ArrayList<Integer> arraylist =  (ArrayList<Integer>) inorderTraversal(root);
        Iterator<Integer> itr = arraylist.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        

    }
    
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

    private static void pushAllLeftNodes(TreeNode root, Stack<TreeNode> stack){
    /*    while(root != null){
            stack.push(root);
            root = root.left;
        }
        */
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }

}
