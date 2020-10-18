package com.company.arrays.dp;

public class MergeStones {

//    int mergeStones(int[] stones, int K) {
//         int n = stones.length;
//        if ((n - K) % (K - 1))
//            return -1;
//        // calculate the sum from 0 to i
//        vector<int> sumStones(n + 1, 0);
//        for (auto i = 0; i < n; ++i) {
//            sumStones[i + 1] = sumStones[i] + stones[i];
//        }
//        // initialize the 3d vector dp
//        vector<vector<vector<int>>> dp(n, vector<vector<int>>(n, vector<int>(K + 1, 1e9)));
//        for (int i = 0; i < n; ++i) {
//            dp[i][i][1] = 0;
//        }
//        // compute the transition functions
//        for (auto stepLen = 2; stepLen <= n; ++stepLen) {
//            for (auto i = 0; i <= n - stepLen; ++i) {
//                int j = i + stepLen - 1;
//                for (auto k = 2; k <= K; k++) {
//                    for ( auto m = i; m < j; m += K - 1) {
//                        dp[i][j][k] = min(dp[i][j][k], dp[i][m][1] + dp[m + 1][j][k - 1]);
//                    }
//                }
//                dp[i][j][1] = dp[i][j][K] + sumStones[j + 1] - sumStones[i];
//            }
//        }
//        return dp[0][n - 1][1];
//    }
}
