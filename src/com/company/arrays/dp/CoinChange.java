package com.company.arrays.dp;

import java.util.*;

public class CoinChange {
    public int coinChang_e(int[] coins, int amount) {

        int curr = amount;
        int ind = coins.length -1;
        int totalCoins = 0;

        while(curr > 0 && ind >= 0){
            int diff = curr - coins[ind];
            if(diff >= 0){
                curr -= coins[ind];
                totalCoins++;
            }
            else{
                ind--;
            }
        }

        if(curr > 0){
            totalCoins = -1;
        }
        return totalCoins;

    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
             for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
                else{
                    break;
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1,2,5};
        int sum = 11;
        System.out.println(c.coinChange(coins, sum));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null){
            return null;
        }

        if(nums.length == 0){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();


        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        List<Integer> res = new ArrayList<>(map.keySet());

        Collections.sort(res, (n1, n2) -> {
            return n2.compareTo(n1);
        });


        return res.stream().limit(k).mapToInt(i -> i).toArray();
    }
}
