package _03_advance._2022_04_01.prime_numbers.assignments;

import java.util.Arrays;

public class PrimeSum {
    public static int[] primesum(int A) {
        boolean[] isPrime1toN = getAllPrime(A+1);
        for (int i = 2; i <= A; i++) {
            if (!isPrime1toN[i] && !isPrime1toN[A-i]) return new int[]{i, A-i};
        }
        return new int[0];
    }

    public static boolean[] getAllPrime(int n){
        boolean[] p = new boolean[n+1];
        Arrays.fill(p, true);
        p[0] = p[1] = false;
        for (int i = 2; i <= Math.ceil(Math.sqrt(n)) ; i++) {
            if (p[i]){
                for (int j = i*i; j <= n; j = j+i) {
                    p[j] = false;
                }
            }
        }
        return p;
    }
}

/*
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal
to the given number.If there is more than one solution possible, return the
lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.
NOTE: A solution will always exist. Read Goldbach's conjecture.

Problem Constraints 4 <= A <= 2*10^7

Input Format : First and only argument of input is an even number A.
Output Format : Return a integer array of size 2 containing primes whose sum will
be equal to given number.

Input : 4, Output : [2, 2]
Explanation : There is only 1 solution for A = 4.
 */