package _03_advance._2022_04_29.two_pointers.live_session;

// TC: O(n), sc: O(1)
public class _01_PairSumSortedArray {
    public static boolean checkIfPairExists(int[] a, int k){
        int n = a.length, p1 = 0, p2 = n-1;
        while (p1 < p2){
            if (a[p1] + a[p2] == k){
                return true;
            }else if (a[p1] + a[p2] < k){
                p1++;
            }else{
                p2--;
            }
        }
        return false;
    }
}

/*
given n distinct sorted elements , check if there exists a pair (i,j) such that
a[i]  + b[j] =  k, Note : i != j

idea-1 : brute force : check all pairs
idea-2 : use hashmap or hashset
idea-3 : for each number check if complimentary number
exists in array with help of binary search (total TC: n log n)
idea-4 : two pointer.

conditions to apply two pointers:
1. where to initialize pointers
2. how to update pointers
3. when to stop pointer movement
 */