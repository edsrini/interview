package com.company.arrays;

import java.util.*;

public class KFrequentNumbers {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null){
            return null;
        }

        if(nums.length == 0){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();



        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List<Integer> res = new ArrayList<>(map.keySet());

        Collections.sort(res, (n1, n2) -> {
            return map.get(n2) - map.get(n1);
        });


        return res.stream().limit(k).mapToInt(i -> i).toArray();
    }


}
