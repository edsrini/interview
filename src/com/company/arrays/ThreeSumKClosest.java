package com.company.arrays;



import java.util.*;

public class ThreeSumKClosest {
    public List<List<Integer>> findSum(int[] arr, int total){
        Arrays.sort(arr);
        int l = arr.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i < arr.length && arr[i] <= total; i ++){
            if(i == 0 || arr[i] != arr[i-1]){
                subSum(result, arr, i, total);
            }
        }
//        List<List<Integer>> ans = new ArrayList<>();
//
//        for(List<Integer> list : result){
//            ans.add(list);
//        }
        return result;
    }

    public void subSum(HashSet<List<Integer>> res,int[] arr, int index, int total){
        int lo = index;
        int hi = arr.length - 1;
        while(lo < hi){
            int sum = arr[index] + arr[lo] + arr[hi];
            if(sum < total){
                lo ++;
            }
            else if(sum > total){
                hi --;
            }
            else{
                res.add(Arrays.asList(arr[index], arr[lo], arr[hi]));
                lo ++;
                hi --;
            }
        }
    }

    public void subSum(List<List<Integer>> res,int[] arr, int index, int total){
        int lo = index;
        int hi = arr.length - 1;
        while(lo < hi){
            int sum = arr[index] + arr[lo] + arr[hi];
            if(sum < total || (lo > index && arr[lo] == arr[lo-1])){
                lo ++;
            }
            else if(sum > total || (hi < arr.length-1 && arr[hi] == arr[hi+1])){
                hi --;
            }
            else{
                res.add(Arrays.asList(arr[index], arr[lo], arr[hi]));
                lo ++;
                hi --;
            }
        }
    }


    public static void main(String[] args) {
        ThreeSumKClosest k = new ThreeSumKClosest();
        int[] input = {-6, 8,4,0,-1,-2,9,14,25,100,110, -3, -1, 0, 2,4,5,2,7};
        System.out.println(Arrays.asList(k.findSum(input, 3)));
    }
 }
