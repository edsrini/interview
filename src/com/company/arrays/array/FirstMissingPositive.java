package com.company.arrays.array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int countOnes = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                countOnes++;
            }
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }

        }

        if(countOnes <= 0){
            return 1;
        }


        for(int i = 0; i < n; i++){
            int a = Math.abs(nums[i]);

            nums[a - 1] = -Math.abs(nums[a -1]);
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i+1;
        }

        return n+1;
    }

    public static void main(String[] args) {
        int a[] = {1,2,0};

        FirstMissingPositive p = new FirstMissingPositive();
        System.out.println(p.firstMissingPositive(a));
    }
}
