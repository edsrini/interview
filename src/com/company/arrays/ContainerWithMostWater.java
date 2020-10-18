package com.company.arrays;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = 0, j = height.length - 1;
        int i = 0;
        while(i < j){
            int curArea = Math.min(height[i], height[j]) * (j -i);
            maxArea = Math.max(curArea, maxArea);

            if(height[i] < height[j]){
                i++;

            }
            else{
                j--;
            }
        }

        return maxArea;
    }

    public static int maxArea_(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] inp = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(inp));
    }
}
