package com.company.BST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConstructBalancedTree {
    public static BST minHeightBst(List<Integer> array) {
        BST n = helper(array, 0, array.size()-1);
        // Write your code here.
        return n;
    }

    public static BST helper(List<Integer> array, int left, int right){

        if(left > right){
            return null;
        }

        int mid = (left+right)/2;
        BST newNode = new BST(array.get(mid));

        newNode.left = helper(array, left, mid -1);
        newNode.right = helper(array, mid + 1, right);

        return newNode;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {5, 7,3,2,1,4};
        List<Integer> l = new ArrayList<>();
        Collections.addAll(l, arr);
        minHeightBst(l);
    }
}
