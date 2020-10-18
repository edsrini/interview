package com.company.arrays.array;

public class MergeSort {
    static int c;
    public static int[] mergeSort(int[] array){
        if(array.length <= 1){
            return array;
        }
        int length = array.length;
        int mid = length/2;

        int[] left = new int[mid];
        int[] right = null;

        if(length%2 == 0){
            right = new int[mid];
        }
        else{
            right = new  int[mid + 1];
        }

        for(int i = 0; i < mid; i++){
            c++;
            left[i] = array[i];
        }
        for(int i = 0; i < right.length; i++){
            c++;
            right[i] = array[mid+i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right){
        int pRight = 0, pLeft = 0, pResult = 0;

        int[] result = new int[left.length + right.length];

        while(pLeft < left.length || pRight < right.length){
            c++;
            if(pLeft < left.length && pRight < right.length){
                if(left[pLeft] < right[pRight]){
                    result[pResult++] = left[pLeft++];
                }
                else{
                    result[pResult++] = right[pRight++];
                }
            }
            else if(pLeft < left.length){
                result[pResult++] = left[pLeft++];
            }
            else{
                result[pResult++] = right[pRight++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,100,6,11,13,18,20,4,3};

        System.out.println("Initial Array: ");
        printArray(arr);
        System.out.println("Sorted Array: ");
        printArray(mergeSort(arr));

        System.out.println("Time complexity "+c);
    }


    public static void printArray(int[] arr){
        for(int i :  arr){
            System.out.println(i);
        }
    }
}
