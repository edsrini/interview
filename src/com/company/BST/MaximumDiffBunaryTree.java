package com.company.BST;

public class MaximumDiffBunaryTree {
    TreeNode root;

    /* Recursive function to calculate maximum ancestor-node
       difference in  binary tree. It updates value at 'res'
       to store the result.  The returned value of this function
       is minimum value in subtree rooted with 't' */
    int maxDiffUtil(TreeNode t, int res)
    {
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (t == null)
            return Integer.MAX_VALUE;

        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return t.val;

        /* Recursively calling left and right subtree
           for minimum value  */
        int val = Math.min(maxDiffUtil(t.left, res),
                maxDiffUtil(t.right, res));

        /* Updating res if (node value - minimum value
           from subtree) is bigger than res  */
        res = Math.max(res, Math.abs(t.val - val));

        /* Returning minimum value got so far */
        return Math.min(val, t.val);
    }

    /* This function mainly calls maxDiffUtil() */
    int maxAncestorDiff(TreeNode root)
    {
        // Initialising result with minimum int value
        int res = Integer.MIN_VALUE;
        maxDiffUtil(root, res);

        return res;
    }

    /* Helper function to print inorder traversal of
       binary tree   */
    void inorder(TreeNode root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.print(root.val + "");
            inorder(root.right);
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.val = value;
            left = null;
            right = null;
        }
    }
}

