package com.company.graph;

import java.util.*;

public class TreeDiameter {

        public int treeDiameter(int[][] edges) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            getMap(edges, map);

            //Find max depth abd go to the node
            int[] node1 = bfs(0, map);
            //From max depth to next depth
            int[] node2 = bfs(node1[0], map);
            return node2[1];
        }

        public int[] bfs(int start, Map<Integer, List<Integer>> map) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> seen = new HashSet<>();
            queue.offer(start);
            seen.add(start);
            int[] res = new int[2];
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();
                    res[0] = node;
                    for (int next : map.get(node)) {
                        if (!seen.contains(next)) {
                            queue.offer(next);
                            seen.add(next);
                        }
                    }
                }
                res[1]++;
            }
            res[1]--;
            return res;
        }

        public void getMap(int[][] edges, Map<Integer, List<Integer>> map) {
            for (int[] edge : edges) {
                if (!map.containsKey(edge[0])) {
                    map.put(edge[0], new ArrayList<>());
                }
                map.get(edge[0]).add(edge[1]);
                if (!map.containsKey(edge[1])) {
                    map.put(edge[1], new ArrayList<>());
                }
                map.get(edge[1]).add(edge[0]);;
            }
        }
    public static void main(String[] args) {
            TreeDiameter d = new TreeDiameter();
        int[][] inp = {{0,1}, {0,2},{2,3}, {3,4},{0,5}, {5,6}};
       // int[] inp = {2,3,1,-4,-4,2};
        //SingleCycle s = new SingleCycle();
        System.out.println(d.treeDiameter(inp));
        // write your code here

    }

}
