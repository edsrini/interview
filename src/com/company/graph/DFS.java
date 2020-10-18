package com.company.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name){
            this.name = name;
        }

        public Node addChild(String name){
            children.add(new Node(name));
            return this;
        }

        public List<String> depthFirstSearch(List<String> array){
            array.add(this.name);
            for(Node c : children){
                c.depthFirstSearch(array);
            }
            return array;
        }
    }
}
