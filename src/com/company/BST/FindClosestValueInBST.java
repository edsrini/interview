package com.company.BST;

public class FindClosestValueInBST {
    public static int findClosestValueInBst(BST tree, int target) {



        // Write your code here.
        return helper(tree, target, tree.value);
    }

    public static int helper(BST tree, int target, int closest) {


        BST currNode = tree;
        if(currNode == null){
            return -1;
        }

        while(currNode != null){
            if(Math.abs(target - closest) > Math.abs(target - currNode.value)){
                closest = currNode.value;
            }

            if(target < currNode.value){
                currNode = currNode.left;
            }
            else if(target > currNode.value){
                currNode = currNode.right;
            }
            else{
                break;
            }
        }
        // Write your code here.
        return closest;
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
