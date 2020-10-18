package com.company.arrays;

import java.util.*;

public class KFrequentWords {
    public List
            <String> topKFrequent(String[] input, int k) {

        Map<String, Integer> words = new HashMap<>();

        for(String s: input){
            words.put(s, words.getOrDefault(s, 0)+1);
        }

        List<String> keys = new ArrayList<>(words.keySet());

        Collections.sort(keys, (w1, w2) -> {
            if(words.get(w1).equals(words.get(w2)))
                return w1.compareTo(w2);
            else
                return words.get(w2) - words.get(w1);
        });

        return keys.subList(0, k);

    }
}
