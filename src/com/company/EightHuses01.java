package com.company;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class EightHuses01
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        int n = states.length;

        int previous = 0;
        int next = 0;
        int first = 0;
        int last = 0;
        int temp = 0;

        for(int d = 0; d < days; d++){
            first = states[0];
            last = states[n-1];
            previous = states[0];
            states[0] = 0 ^ states[1];
            states[n-1] = 0^ states[n-1];

            for(int i = 1; i < n-2; i++){
                temp = states[i];
                if(i == 1){
                    temp = states[i];
                    states[i] = first ^ states[i+1];
                }
                else if(i == n - 2){
                    states[i] = previous ^ last;
                }
                else{
                    states[i] = previous ^ states[i+1];
                }
                previous = temp;

            }
        }

        List<Integer> res = new ArrayList<>();
        for(int s : states){
            res.add(s);
        }
        //res.addAll(states);

        return res;
        // WRITE YOUR CODE HERE
    }
    // METHOD SIGNATURE ENDS
}