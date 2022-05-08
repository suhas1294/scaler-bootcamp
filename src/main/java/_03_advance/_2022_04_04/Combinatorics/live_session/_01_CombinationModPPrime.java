package _03_advance._2022_04_04.Combinatorics.live_session;

import utils.Util;

// TC: O(N + log P), SC : O(1)
public class _01_CombinationModPPrime {
    public static int combinationModP(int n, int r, int p){
        // ans  = (n! % p) + ((n-r)! % p)^p-2 + ((r!) % p)^p-2
        // refer notes for explanation
        int a = Util.factorial(n) % p;
        int b = (int) Util.pow((Util.factorial(n-r) % p), p-2);
        int c = (int)Util.pow((Util.factorial(r) % p), p-2);
        return a + b + c;
    }
}
/*
Give N, R and p, calculate (Ncr)% p
P is prime.
Constraints:
1 <= (N,R) <= 10^5
R < N < P
p is prime

 */
