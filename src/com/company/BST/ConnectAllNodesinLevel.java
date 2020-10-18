package com.company.BST;

import java.util.*;

public class ConnectAllNodesinLevel {
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);


        // Outer while loop which iterates over
        // each level
        while (!Q.isEmpty()) {

            // Note the size of the queue
            int size = Q.size();

            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {

                // Pop a node from the front of the queue
                Node node = Q.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = Q.peek();
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root;
    }

    public Node connect_(Node root) {

        if (root == null) {
            return root;
        }

        List<Node> curr = new ArrayList<>();
        List<Node> next = null;
        // Outer while loop which iterates over
        // each level
        while (!curr.isEmpty()) {
            next = new ArrayList<>();
            int size = curr.size();
            for(int i = 0; i < size; i++){
                Node node = curr.get(i);
                if(i < size){
                    node.next = curr.get(i+1);
                }

                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            curr = next;
        }
        return root;
    }

    static class Node {
        int value;
        Node left;
        Node right;
        Node next;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

}
