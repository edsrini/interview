package com.company.TreeMap;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class RandomPointNonOverLappingRect {
    TreeMap<Integer, int[]> map= new TreeMap<>();
    Random rnd= new Random();
    int area= 0;
    public RandomPointNonOverLappingRect(int[][] rects) {
        for (int[] r: rects){
            int x1=r[0], y1=r[1], x2=r[2], y2=r[3];
            area+=(x2-x1+1)*(y2-y1+1);
            map.put(area, r);
        }
    }

    public int[] pick() {
        int key= map.ceilingKey(rnd.nextInt(area)+1);
        int[] curRec= map.get(key);
        int x1=curRec[0], y1=curRec[1], x2=curRec[2], y2=curRec[3], length=x2-x1, width=y2-y1;
        int x=x1+rnd.nextInt(length+1), y=y1+rnd.nextInt(width+1);
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        int[][] n = {{1, 1, 5, 5}};

        RandomPointNonOverLappingRect p = new RandomPointNonOverLappingRect(n);

        System.out.println(Arrays.toString(p.pick()));
        System.out.println(Arrays.toString(p.pick()));        System.out.println(Arrays.toString(p.pick()));
        System.out.println(Arrays.toString(p.pick()));
        System.out.println(Arrays.toString(p.pick()));        System.out.println(Arrays.toString(p.pick()));        System.out.println(Arrays.toString(p.pick()));        System.out.println(Arrays.toString(p.pick()));



        System.out.println(p.pick());
        System.out.println(p.pick());
        System.out.println(p.pick());
    }
}
