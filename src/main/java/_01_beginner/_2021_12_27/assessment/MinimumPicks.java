package _01_beginner._2021_12_27.assessment;

import java.util.ArrayList;
// given an array, find max even number and least odd number.
public class MinimumPicks {
    public int solve(ArrayList<Integer> A) {
        int curMaxEven = Integer.MIN_VALUE, curMinOdd = Integer.MAX_VALUE;
        for(int i=0; i < A.size(); i++){
            if(A.get(i) % 2 == 0 && A.get(i) > curMaxEven) curMaxEven = A.get(i); // max even value
            if(A.get(i) % 2 != 0 && A.get(i) < curMinOdd) curMinOdd = A.get(i); // min odd value
        }
        return curMaxEven - curMinOdd;
    }
}
