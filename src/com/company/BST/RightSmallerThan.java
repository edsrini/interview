package com.company.BST;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if(array == null || array.size() == 0){
            return new ArrayList<>();
        }

        int lastInd = array.size() - 1;


        SpecailBST bst = new SpecailBST(array.get(lastInd),lastInd, 0);

        for(int i = lastInd - 2; i >=0; i--){
            bst.insert(array.get(i), i);
        }

        List<Integer> lst = new ArrayList<Integer>(array);
        getSmallerCounts(bst, lst);
        return lst;
    }

    public static void getSmallerCounts(SpecailBST bst, List<Integer> count){
        if(bst == null) return;
        count.set(bst.index, bst.numberSmallerCount);
        getSmallerCounts(bst.left, count);
        getSmallerCounts(bst.right, count);
    }

    static class SpecailBST{
        public int value;
        public int index;
        public int numberSmallerCount;
        public int leftSubTreeSize;
        public SpecailBST left;
        public SpecailBST right;

        public SpecailBST(int value, int index, int numberSmallerCount){
            this.value = value;
            this.index = index;
            this.numberSmallerCount = numberSmallerCount;
            leftSubTreeSize = 0;
            left = null;
            right = null;
        }


        public void insert(int value, int ind){
            insertHelper(value, ind, 0);
        }

        public void insertHelper(int value, int ind, int smaller){
            if(value < this.value){
                leftSubTreeSize++;
                if(left == null){
                    left = new SpecailBST(value, ind, smaller);
                }
                else{
                    left.insertHelper(value, ind, smaller);
                }
            }
            else{
                numberSmallerCount += leftSubTreeSize;
                if(value > this.value){
                    numberSmallerCount++;
                }
                if(right == null){
                    right = new SpecailBST(value, ind, numberSmallerCount);
                }
                else{
                    right.insertHelper(value, ind, numberSmallerCount);
                }
            }
        }
    }
}
