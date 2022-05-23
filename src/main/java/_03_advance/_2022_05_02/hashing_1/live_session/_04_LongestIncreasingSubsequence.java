package _03_advance._2022_05_02.hashing_1.live_session;

import java.util.HashSet;
import java.util.Set;

public class _04_LongestIncreasingSubsequence {

    // idea-4 (most optimized) : iterate over hashset instead of array to cover edge case
    // TC : O(n), sc: O(n)
    public static int getLengthOfLongestSeq(int[] a){
        Set<Integer> set = new HashSet<>();
        for (int val : a) set.add(val);
        int ans = 0;
        for (int val : set) {
            if (!set.contains(val-1)){
                int c = 0; // count is 1 since we check that in next while condition
                while (set.contains(val)){
                    val++;
                    c++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }

    // idea-3 : refer notes explanation, tc is still N^2 for edca cases like
    // input = {6,6,6,6,6,7,8,9,10,11}
    public static int getLengthOfLongestSeq2(int[] a){
        Set<Integer> set = new HashSet<>();
        for (int val : a) set.add(val);
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            //when can we start iterating seq from a[i]
            if (!set.contains(a[i]-1)){
                // we can start our sequence from a[i]
                int ele = a[i], c = 0; // count is 1 since we check that in next while condition
                while (set.contains(ele)){
                    ele++;
                    c++;
                }
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }

    // idea-2: O(N^2) sc : O(n) , n^2 bcoz if all elements are already in increasing order by 1
    // 1. insert all elements into hashset
    // 2.take every element as start of the sequence and keep iterating until next element is not present in HS

    // idea-1 : sort + iterate over array and : O(n log n) + O(n)
    public static int getLengthOfLongestSeq1(int[] a) {
        int c = 1, n = a.length, ans = 0; // c=1 since current number will be considered as first element
        for (int i = 0; i < n - 1; i++) {
            if (a[i + 1] - a[i] == 1) { // prev element was decreasing by one
                c = c + 1;
            } else if (a[i + 1] == a[i]) { // repetition
                continue;
            } else { // different number
                ans = Math.max(ans, c);
                c = 1; // reset count to 1
            }
        }
        return Math.max(ans, c); // since for last trace c may be left out.
    }
}
/*
given n array elements, find the length of longer sequence
which can be re-arranged in a strictly increasing order by 1. (consecutive)
Note : sequence meanins pick any index elements, they dont have to be continious.
input : {-1, 8 , 2, 3,7,1,4,9}
seq-1 : {8,3,7,9} - Not possible, wrong sequence, bcoz there is no increasing order
seq-2 : {8,7,9} - can be rearranged to {7,8,9}, length = 3
seq-3 : {2,3,1,4} - can be rearranged to {1,2,3,4}, length = 3

 */