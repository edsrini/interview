package com.company.graph.TopologicalSort;

import java.util.*;

public class AlienDictionary {
    //Time complexity: O(n * k), where n is the length of input array, k is the average length of word.
    //Space complexity: O(1), because the number of node won't exceed 26.



    public String alienOrder(String[] words) {
        Set<Integer>[] adjList = new Set[26];
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        //int count = 0;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree[c-'a'] = 0;

            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            if(w1.startsWith(w2) && w1.length() > w2.length()) return "";

            for (int j = 0; j < w1.length(); j++) {
                if (words[i].charAt(j) != words[i+1].charAt(j)) {
                    int i1 = words[i].charAt(j) - 'a', i2 = words[i+1].charAt(j) - 'a';
                    if (adjList[i1] == null) adjList[i1] = new HashSet<>();
                    if (!adjList[i1].contains(i2)) {
                        adjList[i1].add(i2);
                        degree[i2]++;
                    }
                    break;
                }
            }

        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                stack.push(i);
            }
            if (degree[i] != -1) count++;

        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            count--;
            sb.append((char)(cur + 'a'));
            if (adjList[cur] != null) {
                for (int i : adjList[cur]) {
                    degree[i]--;
                    if (degree[i] == 0) {
                        stack.push(i);
                    }
                }
            }
        }
        if (count == 0) return sb.toString();
        return "";
    }



    public String alienOrder_(String[] words) {
        Map<Character, List<Character>> adj = new HashMap();
        Map<Character, Integer> indegree = new HashMap();

        for(int i = 0; i < words.length; ++i) {
            String w1 = words[i];
            String w2 = i == words.length - 1? "": words[i+1];
            // if the order is wrong, like ["abc", "ab"], return empty string
            if(w2.length() > 0 && w1.startsWith(w2) && !w1.equals(w2)) return "";
            //boolean check = false;
            for(int j = 0; j < w1.length(); ++j) {
                char c1 = w1.charAt(j);
                indegree.put(c1, indegree.getOrDefault(c1, 0));
                if(j < w2.length() && c1 != w2.charAt(j)) {
                    //check = true;
                    char c2 = w2.charAt(j);
                    if(!adj.containsKey(c1)) adj.put(c1, new ArrayList());
                    adj.get(c1).add(c2);
                    indegree.put(c2, indegree.getOrDefault(c2, 0) + 1);
                    break;
                }
            }
        }

        Stack<Character> q = new Stack<>();
        for(char c: indegree.keySet()) {
            if(indegree.get(c) == 0) q.push(c);
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()) {
            char cur = q.pop();
            res.append(cur);
            if(adj.get(cur) == null) continue;
            for(char nei: adj.get(cur)) {
                int degree = indegree.get(nei);
                indegree.put(nei, degree - 1);
                if(degree == 1) q.push(nei);
            }
        }
        return res.length() == indegree.size()? res.toString(): "";
    }
    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        //String[] words = {"za","zb","ca","cb"};
       // String[] words = {"zab","cd"};
        //String[] words = {"za","zb","cd"};
        //String[] words = {"abc", "ab", "er", "ett", "rftt"};
        //String[] words = {"z", "w", "z"};
        //String[] words = {"ab","adc"};
        AlienDictionary ad = new AlienDictionary();
        System.out.println(ad.alienOrder(words));

    }
}
