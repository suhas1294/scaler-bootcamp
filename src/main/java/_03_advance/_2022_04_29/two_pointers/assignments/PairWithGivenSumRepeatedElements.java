package _03_advance._2022_04_29.two_pointers.assignments;

public class PairWithGivenSumRepeatedElements {
    //1. Start two pointers from beginning & end
    //2. If (a[l] + a[r] == sum) then increment global "ans" variable
    //3. To handle duplicates, count all duplicate values equal to a[r] and add it to global variable
    public static int solve(int[] a, int k) {
        int mod = 1000*1000*1000+7;
        int l=0,r=a.length-1,ans=0;
        while(l < r){
            int sum = a[l]+a[r];
            if(sum == k){
                int count = 0, prev=r;
                while(prev > l && a[r] == a[prev]) {//count duplicate values from right pointer
                    count ++;
                    prev--;
                }
                ans = (ans + count)%mod;
                l++;
            }else if(sum < k){
                l++;
            }else if(sum > k){
                r--;
            }
        }
        return ans;
    }
}
/*
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of
integers ( A[i], A[j] ) such that i != j have sum equal to B.
Since the number of such pairs can be very large, return number of such pairs modulo (10^9 + 7).

Problem Constraints
1 <= |A| <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).

Input 1: A = [1, 1, 1] B = 2 Output 1: 3
Input 2: A = [1, 1] B = 2 Output 2: 1

Explanation 1: Any two pairs sum up to 2.
Explanation 2: only pair (1, 2) sums up to 2.
 */
