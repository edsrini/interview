package com.company.heap;

import java.util.PriorityQueue;

public class PriorityQueueSample {
    public static int testMaxHeap(int [] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>(3, (n1, n2) -> n2 - n1);
        for(int n : arr){
            queue.add(n);
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        int[] arr = {3,9,1,6,4,8,2};
        int mh = testMaxHeap(arr);
        System.out.println(mh);
    }
}
