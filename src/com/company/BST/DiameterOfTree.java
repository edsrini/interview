package com.company.BST;

public class DiameterOfTree {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        depth(root);
        return ans;
    }

    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }

        int lHeight = depth(root.left);
        int rHeight = depth(root.right);
        ans = Math.max(ans, lHeight+rHeight);
        return Math.max(lHeight, rHeight)+1;
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

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.right = new TreeNode(3);
        n.left.left = new TreeNode(4);
        n.left.right = new TreeNode(5);

        DiameterOfTree d = new DiameterOfTree();
        d.diameterOfBinaryTree(n);
    }
}


