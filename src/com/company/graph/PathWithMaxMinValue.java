package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathWithMaxMinValue {
    int dirX[] = new int[]{1, -1, 0, 0};
    int dirY[] = new int[]{0, 0, -1, 1};

    //BFS O(r*c)
    public boolean can(int[][] A, int val) {
        Queue<int[]> q = new LinkedList<>();

        if (A[0][0] < val) {
            return false;
        }

        q.add(new int[]{0,0});
        int[][] vis = new int[A.length][A[0].length];
        while(!q.isEmpty()) {
            int[] pt = q.poll();
            if (pt[0] == A.length -1 && pt[1] == A[0].length-1) {
                return true;
            }

            vis[pt[0]][pt[1]] = 1;
            for (int d = 0; d < 4; d++) {
                int nX = pt[0] + dirX[d];
                int nY = pt[1] + dirY[d];

                if (nX >= 0 && nY >=0 && nX <A.length && nY<A[0].length) {
                    if (vis[nX][nY] == 0 && A[nX][nY] >= val) {
                        q.add(new int[]{nX, nY});
                    }
                    vis[nX][nY] = 1;
                }
            }
        }

        return false;
    }



    public int maximumMinimumPath(int[][] A) {
        int l = Integer.MAX_VALUE; int r = 0;

        //Finding min and max values to run binary search O(r*c) r: no of rows c: no of columns
        for (int[] arr : A)
            for (int val : arr) {
                l = Math.min(l, val);
                r = Math.max(val, r);
            }

        //Doing Binary search to find median O(log n)
        while (l < r - 1) {
            int mid = l + (r-l) / 2;
            //Checking if the median is a candidate for our solution
            if (can(A, mid)) {
                l = mid;
            }
            else {
                r = mid;
            }
        }

        if (can(A, r)) {
            return r;
        }

        return l;

    }

    public static void main(String[] args) {
        int[][] a = {{5,4,5},{1,2,6},{7,4,6}};

        PathWithMaxMinValue o = new PathWithMaxMinValue();

        int val = o.maximumMinimumPath(a);
    }
}
