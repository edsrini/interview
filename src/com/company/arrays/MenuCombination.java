package com.company.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MenuCombination {
    static String[] ingredients = {"tomoatoe", "Cucmber"};

    public List<List<String>> subsets(String[] nums) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        result.add(curr);
        find(result, curr, 0, ingredients);
        return result;

    }

    public void find(List<List<String>> result, List<String> curr, int index, String[] nums){
        if(index == nums.length){
            return;
        }

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            result.add(new ArrayList(curr));
            find(result, curr, i+1, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        MenuCombination c = new MenuCombination();
        System.out.println(Arrays.asList(c.subsets(ingredients)));
    }
}
