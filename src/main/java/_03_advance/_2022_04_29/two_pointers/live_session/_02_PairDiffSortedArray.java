package _03_advance._2022_04_29.two_pointers.live_session;

// TC: O(n), sc: O(1)
// Note : If k is -ve, take absolute value of k, so that same pair exists but with diff signs.
public class _02_PairDiffSortedArray {
    public static boolean checkIfPairExists(int[] a, int k){
        int n = a.length, p1 = 0, p2 = 1;
        while (p2 < n){
            if (a[p2] - a[p1] == k){
                return true;
            }else if (a[p2] - a[p1] > k){
                p1++;
                if (p1 == p2) p2++;
            }else{
                p2++;
            }
        }
        return false;
    }
}

/*
given n distinct sorted elements , check if there exists a pair (i,j) such that
a[j]  - a[i]  = k and k > 0, Note : i != j

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