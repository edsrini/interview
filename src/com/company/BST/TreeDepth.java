package com.company.BST;

import java.util.*;

class TreeDepth {

    public static int TreeDepth(BinaryTree root) {
        // Write your code here.
        return findDepth(root, 0);
    }

    public static int findDepth(BinaryTree root, int depth){
        if(root == null){
            return 0;
        }
        return depth + findDepth(root.left, depth+1) + findDepth(root.right, depth+1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}

