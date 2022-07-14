package _03_advance._2022_07_11.backtracking_1.live_session;

import java.util.Arrays;
import java.util.List;

public class SubSetsWithSumEqK {
    // tc : 2^n * 1, sc : O(1) [stack size]
    int subSetsWitSumEqK(int[] a, int n, int k, int i, int sum){
        if (i == n){        // base condition
            if (sum == k) {
                return 1;
            }else{
                return 0;
            }
        }
        int c = 0;
        // pick ith element and do function call
        sum = sum + a[i];
        c = c + subSetsWitSumEqK(a, n, k, i+1, sum);
        // leave ith element (revert changes and do function call)
        sum = sum - a[i]; // revert step in backtracking
        c = c + subSetsWitSumEqK(a, n, k, i+1, sum);
        return c;
    }

    // tc : 2^n * n, sc : O(1) [stack size]
    // here one extra method parameter we are taking - list
    void printSubsetsWitSumEqK(int[] a, int n, int k, int i, int sum, List<Integer> list){
        if (i == n){
            if (sum == k) System.out.println(list);
            return;
        }

        sum = sum + a[i];
        list.add(a[i]);
        printSubsetsWitSumEqK(a, n, k, i+1, sum, list);

        sum = sum - a[i];
        list.remove(list.size()-1); // remove last element in list
        printSubsetsWitSumEqK(a, n, k, i+1, sum, list);
    }
}

/*
given n array elements and an integer k, count no of subsets with sum = k
array consists of both positive and negative elements
ex : {10, 2,7, 6,1,5} , k = 8
ans : 3
subsets  :{2,6}, {1,7}, {5,2,1}
note  : solving this using bit masking will take O(2^n * n) as TC
 */