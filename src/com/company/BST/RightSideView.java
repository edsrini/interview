package com.company.BST;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(HeightBST.TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        List<HeightBST.TreeNode> currLevel = new ArrayList<>();

        List<HeightBST.TreeNode> nextLevel = null;

        currLevel.add(root);



        HeightBST.TreeNode node = null;
        while(!currLevel.isEmpty()){
            result.add(currLevel.get(currLevel.size() -1).value);
            nextLevel =  new ArrayList<HeightBST.TreeNode>();
            for (int i=0; i < currLevel.size(); i++) {
                node = currLevel.get(i);

                if (node.left != null) {
                    nextLevel.add(node.left);
                }

                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            currLevel = nextLevel;

        }

        return result;

    }
}
