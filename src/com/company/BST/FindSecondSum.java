package com.company.BST;

public class FindSecondSum {
    int min1;
    long min2 = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        //PriorityQueue<Integer> q = new PriorityQueue<>();
        min1 = root.val;
        traverse(root);

        return min2 < Long.MAX_VALUE ? (int)min2 : -1;
    }

    public void traverse(TreeNode node){
        if(node == null)
            return;
        if(node.val < min1){
            min2 = min1;
            min1 = node.val;
        }
        else if(node.val > min1 && node.val < min2){
            min2 = node.val;
        }
        traverse(node.left);
        traverse(node.right);
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
