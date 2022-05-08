package _03_advance._2022_04_01.prime_numbers.assignments;

import _03_advance._2022_04_01.prime_numbers.PrimeUtil;

public class PrimeSubsequences {
    public static int solve(int[] A) {
        int count = 0;
        int ans = 0;
        int mod = 1000000007;
        for(int i=0; i<A.length;i++){
            if(PrimeUtil.isPrime(A[i])){
                ans = (int) ((ans%mod+ Math.pow(2, count)%mod)%mod);
                //System.out.println(A.get(i));
                count++;
            }
        }
        return ans;
    }
    // approach : as we can observe that as the number of prime numbers are increasing numbers of subsequences are inscreasing in a pattern i.e.
    //1 + 2 + 4 + 8, this can also be written as 1 + (1+1) + (2+2) + (4+4) so everytime we find a prime number we add the count to itself.
}

/*
Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
A Prime subsequence is one that has only prime numbers, for example [2, 3], [5]
are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.

Input Format : The first argument given is an Array A, having N integers.
Output Format : Return an integer X, i.e number of Prime subsequences.
As X can be very large print X % (1000000007), here % is modulus operator.

Constraints
1 <= N <= 1e3
1 <= A[i] <= 1e6

Input: A = [1, 2, 3] Output: 3

Explanation:
    no. Subsequences      Prime subsequences
    1.  [1]                     No
    2.  [1, 2]                  No
    3.  [1, 3]                  No
    4.  [1, 2, 3]               No
    5.  [2]                     Yes
    6.  [2, 3]                  Yes
    7.  [3]                     Yes
    8.  []                      No

here we have 3 subsequences(5, 6, 7) those have only prime number(s).

 */