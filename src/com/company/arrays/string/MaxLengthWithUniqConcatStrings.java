package com.company.arrays.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxLengthWithUniqConcatStrings {
    int result = Integer.MIN_VALUE;
    public int maxLength(List<String> arr) {

        maxUniqueChars(arr, 0, "");
        return  result;
    }

    public void maxUniqueChars(List<String> arr, int ind, String curr){
        if(ind == arr.size() && uniqueChars(curr) > result){
            result = curr.length();
            return;
        }
        if(ind == arr.size()){
            return;
        }

        maxUniqueChars(arr, ind+1, curr);
        maxUniqueChars(arr, ind+1, curr+arr.get(ind));
    }

    public int uniqueChars(String s){
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            if(chars[c - 'a'] > 0){
                return -1;
            }
            chars[c - 'a'] = 1;
        }
        return s.length();
    }

    public static void main(String[] args) {
        List<String> ls = Arrays.asList("un","iq","ue");

        MaxLengthWithUniqConcatStrings m = new MaxLengthWithUniqConcatStrings();
        System.out.println(m.maxLength(ls));
    }
}
