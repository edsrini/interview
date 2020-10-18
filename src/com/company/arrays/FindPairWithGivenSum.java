package com.company.arrays;

import java.util.*;

public class FindPairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 10, 25, 35, 60};
        int[] arr1 = {20, 50, 40, 25, 30, 10};
        int[] arr2 = {5, 55, 40, 20, 30, 30};
        test(arr, 90);
        test(arr1, 90);
        test(arr2, 90);
    }

    private static void test(int[] nums, int target) {
        System.out.println(findPairSum(nums, target));
    }

    public static List<Integer> findPairSum(int[] arr, int target)
    {
        if(arr.length <= 1){
            return null;
        }
        List<Integer> pairs = null;
        Map<Integer, Integer> compliments = new HashMap<>();
        target -= 30;
        int largest = -1;

        for(int i =0; i < arr.length; i++){
            int compliment = target - arr[i];
            if((arr[i] > largest || compliment > largest) && (compliments.containsKey(compliment))){
                pairs = new ArrayList<>();
                pairs.add(compliment);
                pairs.add(arr[i]);
                largest =  Math.max(arr[i], compliment);
            }
            compliments.put(arr[i], i);
        }

        return pairs;
    }
}
