package com.company.graph.TopologicalSort;

public class SingleCycle {
    public static boolean hasSingleCycle(int[] array) {
        int start = array[0];
        int numVisited = 0;
        int currIdx = 0;
        int n = array.length;

        while(numVisited < n){
            if(numVisited > 0 && currIdx == 0){
                return false;
            }
            numVisited++;
            currIdx = getNextIx(currIdx, array);
        }

        // Write your code here.
        return currIdx == 0;
    }

    public static int getNextIx(int idx, int[] array){
        int jump = array[idx];
        int nextIdx = (idx+jump)%array.length;
        return nextIdx >= 0? nextIdx: nextIdx+array.length;
    }

    public static void main(String[] args) {
        //int[][] inp = {{1,0}, {0,2}};
        int[] inp = {2,3,1,-4,-4,2};
        //SingleCycle s = new SingleCycle();
        System.out.println(hasSingleCycle(inp));
        // write your code here

    }
}
