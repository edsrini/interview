package com.company.string;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];

        for(int i = 0; i < s.length(); i ++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int j = 0; int end = 0;

        List<Integer> partitions = new ArrayList<>();

        for(int i =0; i< s.length(); i++){
            j = Math.max(j, lastIndex[s.charAt(i) - 'a']);
            if(i == j){
                partitions.add((j - end) + 1);
                end = j + 1;
            }
        }

        return partitions;
    }
}
