package com.company.heap;

import java.util.PriorityQueue;

public class MinCostRope {
    public int findMinSum(int[] array){
        if(array == null){
            return -1;
        }
        if(array.length == 1){
            return array[0];
        }
        if(array.length == 2){
            return array[0]+array[1];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(int n : array){
            queue.add(n);
        }
        int minSum = 0;

        while(queue.size() > 1){
            int num1 = queue.poll();
            int num2 = queue.poll();
            minSum += num1 + num2;
            queue.add(num1 + num2);
        }
        return minSum;
    }

    public static void main(String[] args) {
        MinCostRope m = new MinCostRope();
        int[] arr = {8, 4, 6, 12};

        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.add(8);
        p.add(4);
        p.add(6);
        p.add(12);

        p.remove(8);

        System.out.println(m.findMinSum(arr));
    }
}
