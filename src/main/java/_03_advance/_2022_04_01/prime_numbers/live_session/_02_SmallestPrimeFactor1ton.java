package _03_advance._2022_04_01.prime_numbers.live_session;

import java.util.ArrayList;

public class _02_SmallestPrimeFactor1ton {
    // TC: O(N log (log N)), sc : O(n)
    public static int[] getAllSPF(int n){
        int[] spf = new int[n+1];
        for (int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }
        spf[0] = 0;
        spf[1] = 1;
        for (int i = 2; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (i == spf[i]){ // prime & multiples
                for (int j = i*i; j <= n ; j = j+i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
        return spf;
    }

    public static void main(String[] args) {
        int[] spf = getAllSPF(10);
        for (int val: spf) {
            System.out.print(val + "\t");
        }
    }

}

/*
Given n, for all numbers from 1 to n , stores its SPF (smallest prime factor)

ex: n : 10
num: 1   2   3   4   5   6   7   8   9   10
spf: 1   2   3   2   5   2   7   2   3   2

 */