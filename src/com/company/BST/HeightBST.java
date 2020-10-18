package com.company.BST;

import java.util.*;

class HeightBST {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height+1, right_height+1);
        }
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public int maxDepth_(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> depths = new LinkedList<>();
        if (root == null) return 0;

        stack.add(root);
        depths.add(1);

        int depth = 0, current_depth = 0;
        while(!stack.isEmpty()) {
            root = stack.pollLast();
            current_depth = depths.pollLast();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                stack.add(root.left);
                stack.add(root.right);
                depths.add(current_depth + 1);
                depths.add(current_depth + 1);
            }
        }
        return depth;
    }

    public int maxDepthIteration(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        nodes.add(root);
        depths.add(1);
        int currentDepth = 0;
        int depth = 0;

        while(!nodes.empty()){
            TreeNode node = nodes.pop();
            currentDepth = depths.pop();

            if(node != null){
                depth = Math.max(depth, currentDepth);

                nodes.add(node.left);
                nodes.add(node.right);

                depths.add(currentDepth+1);
                depths.add(currentDepth+1);
            }
        }

        return depth;
    }

    public int findDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int height = Integer.MIN_VALUE;

        if(root.left != null) {
            height = Math.max(findDepth(root.left), height);
        }
        else{
            height = Math.max(findDepth(root.right), height);
        }

        return height + 1;
    }

    public int minDepth(TreeNode root){
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }


    public int minDepth_(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = minDepth_(root.left);
            int right_height = minDepth_(root.right);
            return java.lang.Math.min(left_height+1, right_height+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(3);
        root.left.left.left.left = new TreeNode(3);
        root.left.left.left.left.right = new TreeNode(3);

        HeightBST h = new HeightBST();
        int ht = h.maxDepthIteration(root);
        System.out.println(ht);
        int ht2 = h.findDepth(root);
        System.out.println(ht2);
        int ht3 = h.minDepth(root);
        System.out.println(ht3);
        int ht4 = h.minDepth_(root);
        System.out.println(ht4);



    }
}