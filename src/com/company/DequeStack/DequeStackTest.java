package com.company.DequeStack;

import java.util.*;
import java.util.stream.Collectors;

public class DequeStackTest {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        List<Integer> numbers = Arrays.stream(arr).boxed().collect(Collectors.toList());

        Deque<Integer> d =new ArrayDeque<>(numbers);

        d.push(10);

        d.peek();



        d.addFirst(11);
        d.add(12);
        d.addLast(13);

        System.out.println(d.poll());
        System.out.println(d.removeFirst());
        System.out.println(d.poll());
        System.out.println(d.poll());



        List<List<Integer>> numberSet = new ArrayList<>();
        //int[][] ay = new int[][];
        //ay[0] = {1,2,3};
    }
}
