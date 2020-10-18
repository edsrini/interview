package com.company.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetTestSaneArrays {
    public static void main(String[] args) {
        Set<List<Integer>> s = new HashSet<>();

        s.add(Arrays.asList(1,2,3));
        s.add(Arrays.asList(1,2,3));
        s.add(Arrays.asList(1,2,3));
        s.add(Arrays.asList(2,1,3));
        System.out.println(s);

        Set<List<String>> st = new HashSet<>();

        st.add(Arrays.asList("tom", "car", "spin"));
        st.add(Arrays.asList("tom", "car", "spin"));
        st.add(Arrays.asList("tom", "car", "spin"));
        st.add(Arrays.asList("tom", "car", "s"));
        System.out.println(st);



    }
}
