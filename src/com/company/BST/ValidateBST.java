package com.company.BST;

public class ValidateBST {
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return helper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(BST tree, int val1, int val2){
        if(tree.value < val1 || tree.value >= val2){
            return false;
        }

        if(tree.left != null && !helper(tree.left, val1, tree.value)){
            return false;
        }
        else if(tree.right != null && !helper(tree.right, tree.value, val2)){
            return false;
        }
        else{
            return true;
        }
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
