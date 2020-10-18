package com.company.arrays.dp;

import java.util.Arrays;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];

        for(int[] a: dp){
            Arrays.fill(a,1);
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n -1];

    }
}
