package com.company.graph;

import java.util.*;

public class CriticalConnections {
    List<List<Integer>>  list;
    Map<Integer, Boolean> visited;
    List<List<Integer>> criticalConnections(int numOfServers,
                                      List<List<Integer>> connections)
    {
        int numOfConnections = connections.size();
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(List<Integer> c : connections){
            int u = c.get(0);
            int v = c.get(1);
            if(adj.get(u) == null){
                adj.put(u,new HashSet<Integer>());
            }
            adj.get(u).add(v);
            if(adj.get(v) == null){
                adj.put(v,new HashSet<Integer>());
            }
            adj.get(v).add(u);
        }

        list = new ArrayList<>();
        for(int i =0;i<numOfConnections;i++){
            visited = new HashMap<>();
            List<Integer>  p = connections.get(i);
            int x = p.get(0);
            int y = p.get(1);
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj,1);
            if(visited.size()!=numOfServers){
                if(p.get(0) > p.get(1)) {
                    List<Integer> l = new LinkedList<>();
                    l.add(p.get(0));
                    l.add(p.get(1));
                    list.add(l);

                }
                else
                    list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }

    public void DFS(Map<Integer, HashSet<Integer>> adj, int u){
        visited.put(u, true);
        if(adj.get(u).size()!=0){
            for(int v : adj.get(u)){
                if(visited.getOrDefault(v, false)== false){
                    DFS(adj,v);
                }
            }
        }
    }

    class PairInt{
        int first;
        int second;

        public PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        CriticalConnections obj = new CriticalConnections();

        int numRouters1 = 7;
        int numLinks1 = 7;
        int[][] links1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};

        List<List<Integer>> list = new ArrayList<>();
        for (int[] array : links1) {
            List<Integer> l = new ArrayList<>();
            l.add(array[0]);
            l.add(array[1]);
            list.add(l);
        }


        System.out.println(Arrays.asList(obj.criticalConnections(numRouters1, list)));



        int[][] links2 = {{0,1},{1,2},{2,0},{1,3}};

        list = new ArrayList<>();
        for (int[] array : links2) {
            List<Integer> l = new ArrayList<>();
            l.add(array[0]);
            l.add(array[1]);
            list.add(l);
        }
        System.out.println(Arrays.asList(obj.criticalConnections(4, list)));
//        List<Integer> res = obj.getCriticalRouters(numRouters1, numLinks1, links1);
//
//        for(int i: res) System.out.print(i + " ");
//        System.out.println();
//
//        int numRouters2 = 5;
//        int numLinks2 = 5;
//        int[][] links2 = {{1,2}, {0,1}, {2,0}, {0,3}, {3,4}};
//
//        List<Integer> res2 = obj.getCriticalRouters(numRouters2, numLinks2, links2);
//        for(int i: res2) System.out.print(i + " ");
//        System.out.println();
//
//        int numRouters3 = 4;
//        int numLinks3 = 4;
//        int[][] links3 = {{0,1},{1,2},{2,3}};
//
//        List<Integer> res3 = obj.getCriticalRouters(numRouters3, numLinks3, links3);
//        for(int i: res3) System.out.print(i + " ");
//        System.out.println();
//
//        int numRouters4 = 7;
//        int numLinks4 = 8;
//        int[][] links4 = {{0,1},{0,2},{1,2},{1,3},{1,4},{1,6},{3,5},{4,5}};
//
//        List<Integer> res4 = obj.getCriticalRouters(numRouters4, numLinks4, links4);
//        for(int i: res4) System.out.print(i + " ");
//        System.out.println();
    }
}
