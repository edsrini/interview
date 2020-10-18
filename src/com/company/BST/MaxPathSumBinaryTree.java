package com.company.BST;

//Hard

public class MaxPathSumBinaryTree {

    int max_gain = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        max_gain(root);
        return max_gain;

    }

    public int max_gain(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = max_gain(node.left);
        int right = max_gain(node.right);

        int newPath = node.val + left + right; // to-check max path if current node is root

        max_gain = Math.max(max_gain, newPath); //taking max gain

        return node.val + Math.max(left, right); //Straight path to include next higher node
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
        n.right.left = new TreeNode(1);
        n.right.left = new TreeNode(2);
        n.left.left = new TreeNode(1);
        n.left.right = new TreeNode(3);

        MaxPathSumBinaryTree d = new MaxPathSumBinaryTree();
        int m = d.maxPathSum(n);
        System.out.println(m +"   "+d.max_gain);
    }

}
