package com.company.graph;

public class MinMaxPath {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 7}, {5, 3}};
        int[][] grid2 = {{1,2,3}, {7,8,9}, {4,5,6}};
        int[][] grid3 = {{7,5,3}, {2,0,9}, {4,5,9}};
        System.out.println(getMinMax(grid1));
        System.out.println(getMinMax(grid2));
        System.out.println(getMinMax(grid3));

        System.out.println(maxScore2D(grid1));
        System.out.println(maxScore2D(grid2));
        System.out.println(maxScore2D(grid3));
    }

    private static int getMinMax(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int top =  i > 0 ? dp[i - 1][j] : Integer.MIN_VALUE;
                int left = j > 0 ? dp[i][j - 1] : Integer.MIN_VALUE;
                dp[i][j] = Math.max(Math.min(top, grid[i][j]), Math.min(left, grid[i][j]));
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    //https://www.junhaow.com/lc/problems/heap/1102_path-with-maximum-minimum-value.html

    private static int maxScore2D(int[][] grid) {
        // Assume there is at least one element
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];
        // Init
        dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
        for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
        for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
        // DP
        for (int i = 1; i < r; ++i) { // row by row
            for (int j = 1; j < c; ++j) {
                if (i == r - 1 && j == c - 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
                } else {
                    int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
                    int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
                    dp[i][j] = Math.max(score1, score2);
                }
            }
        }
        return dp[r - 1][c - 1];
    }

}
