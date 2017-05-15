package jz.BinarySearchTree;

public class TreeNode {
    
	int key;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}

	
    public static void preOrder(TreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public static TreeNode fromString(String str)
    {
        // [3,9,20,null,null,15,7]
        String s = str.substring(1, str.length() - 1);
        String[] treeNodes = s.split(",");

        int length = treeNodes.length;
        TreeNode root = null;

        for (int i = 0; i < length; i++)
        {
            TreeNode tmp = treeNodes[i].equalsIgnoreCase("null") ? null
                    : (new TreeNode(Integer.parseInt(treeNodes[i])));

            if (tmp != null)
            {
                if (root == null)
                    root = tmp;

                if ((2 * i + 1) < length)
                    tmp.left = treeNodes[2 * i + 1].equalsIgnoreCase("null") ? null
                            : new TreeNode(Integer.parseInt(treeNodes[2 * i + 1]));

                if ((2 * i + 2) < length)
                    tmp.right = treeNodes[2 * i + 2].equalsIgnoreCase("null") ? null
                            : new TreeNode(Integer.parseInt(treeNodes[2 * i + 2]));

            }
        }

        return root;

    }

}
