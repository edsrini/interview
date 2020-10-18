package com.company.arrays.dp;

public class RobHouses {
    public int rob(int[] nums) {

        int size = nums.length;

        if(size == 1){
            return nums[0];
        }

        if(size == 2){
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(helper(nums, 0, size -2), helper(nums, 1, size -1));
    }

    public int helper_(int[] nums, int start, int end){
        int curr = 0;
        int prev = 0;

        for(int i = start; i <= end; i++){
            int temp = curr;

            curr = Math.max(prev + nums[i], curr);
            prev =temp;
        }

        return curr;
    }

    public int helper(int[] nums, int start, int end){
        int[] dp = new int[end-start + 1];

        dp[0] = nums[start];
        dp[1] = Math.max(dp[0], nums[start+1]);
        int j = 2;
        for(int i = start + 2;i <= end; i++){
            dp[j] = Math.max(dp[j-2]+nums[i], dp[j-1]);
            j++;
        }
        return dp[dp.length  - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1,7,9,2};

        RobHouses r = new RobHouses();
        r.rob(arr);


    }
}
