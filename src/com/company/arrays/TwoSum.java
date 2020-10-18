package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compliments = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int compliment = target - nums[i];
            if(compliments.containsKey(compliment)){
                return new int[]{compliments.get(compliment), i};
            }
            compliments.put(nums[i], i);
        }
        return null;
    }
}
