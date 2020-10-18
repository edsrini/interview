package com.company.TreeMap;

import java.util.Random;
import java.util.TreeMap;

public class RandomPick {

    static int cnt=0;
    TreeMap<Integer, Integer> map= new TreeMap<>();
    static Random rnd= new Random();

    public RandomPick(int[] w) {
        for (int idx=0; idx<w.length; idx++){
            cnt+=w[idx];
            map.put(cnt, idx);
        }
    }

    public int pickIndex() {
        int key= map.higherKey(rnd.nextInt(cnt));
        return map.get(key);
    }

    public static void main(String[] args) {
        int[] n = {2, 8};

        RandomPick p = new RandomPick(n);

        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());
        System.out.println(p.pickIndex());


        // creating object of TreeMap<Integer, String>
        TreeMap<Integer, String>
                treemap = new TreeMap<Integer, String>();

        // populating tree map
        treemap.put(1, "One");
        treemap.put(2, "Two");
        treemap.put(3, "Three");
        treemap.put(4, "Four");
        treemap.put(5, "Five");

        // pritnig the TreeMap
        System.out.println("TreeMap: " + treemap);

        // getting higher key value for 3
        // using higherKey() method
        int value = treemap.higherKey(rnd.nextInt(5));

        // printing the value
        System.out.println("The higherKey value "
                + " for 3: " + value);
    }
}
