package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //sort array
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet();
        for (int i = 0; i < nums.length - 1 && nums[i] <= 0; i++){
            if (i == 0 || nums[i] != nums[i - 1]){
                sumZero(res, nums, i);
            }
        }

        List<List<Integer>> resList = new ArrayList<>();
        for (List<Integer> r : res){
            resList.add(r);
        }
        return resList;
    }

    private void sumZero(HashSet<List<Integer>> res, int[] nums, int index){
        int left = index + 1;
        int right = nums.length - 1;

        while (left < right){
            int sum = nums[index] + nums[left] + nums[right];
            if (sum > 0){
                right--;
            } else if (sum < 0){
                left++;
            } else {
                res.add(Arrays.asList(nums[index], nums[left], nums[right]));
                right--;
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={-2,0,0,2,2, -2};
        ThreeSum t =new ThreeSum();
        List<List<Integer>> ans = t.threeSum(arr);
        System.out.println(Arrays.asList(ans));
    }
}
