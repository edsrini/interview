package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubArray {

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map< Integer, Integer > map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContinousSubArray s = new ContinousSubArray();
        int[] arr = {1,3,5,1,2};
        //int[] arr = {0};
        System.out.println( s.checkSubarraySum(arr, 3));

    }
}
