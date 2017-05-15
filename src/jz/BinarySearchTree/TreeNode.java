package jz.BinarySearchTree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode
{

    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key)
    {
        this.key = key;
        this.left = null;
        this.right = null;
    }


    public static TreeNode fromString(String str)
    {
        if (str == null)
        {
            return null;
        }
        
        if(str.startsWith("["))
            str = str.substring(1, str.length()-1);

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
    public static String toString(TreeNode root)
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
            if (tmp.key == Integer.MIN_VALUE)
            {
                sb.append("#,");
            }
            else
            {
                sb.append(tmp.key + ",");
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

    public static void main(String[] args)
    {
        String s = "5,4,7,3,#,2,#,-1,#,9";
        
        System.out.println(s);
        TreeNode root  = fromString(s);
        System.out.println(toString(root));

    }
}
