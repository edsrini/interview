package com.company.arrays.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;

        for (int num : set) {

            if(set.contains(num -1)){
                continue;
            }

            int currNume = num;
            int length = 1;

            while (set.contains(currNume+1)) {
                currNume += 1;
                length += 1;
            }

            result = Math.max(result, length);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(arr));
    }

}
