package com.company.arrays;

public class OrderSqrOfNumbers {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int i = 0, j = 0;
        while(A[j] < 0 && j < n -1){
            j++;
        }

        i = j-1;

        int[] res = new int[n];
        int t = 0;

        while(i >= 0 && j < n){
            if(A[i] * A[i] < A[j] * A[j]){
                res[t++] = A[i] * A[i];
                i--;
            }
            else{
                res[t++] = A[j] * A[j];
                j++;
            }
        }

        while(i >= 0){
            res[t++] = A[i] * A[i];
            i--;
        }

        while(j < n){
            res[t++] = A[j] * A[j];
            j++;
        }
        return res;
    }
}
