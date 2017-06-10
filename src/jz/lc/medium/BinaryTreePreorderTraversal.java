package jz.lc.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import jz.tree.bst.BinarySearchTree;
import jz.tree.bst.TreeNode;

public class BinaryTreePreorderTraversal
{

    public static void main(String[] args)
    {
        TreeNode root = TreeNode.fromString("1,2,3,4,5,6,7");
        BinarySearchTree bst = new BinarySearchTree(root);
        bst.preOrder();
        System.out.println();
        
        ArrayList<Integer> arraylist =  (ArrayList<Integer>) preorderTraversal(root);
        Iterator<Integer> itr = arraylist.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() + " ");
        }
        

    

    }
    

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        stack.push(cur);
        
        while(!stack.isEmpty()){
            cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
        
        return res;
    }
}
