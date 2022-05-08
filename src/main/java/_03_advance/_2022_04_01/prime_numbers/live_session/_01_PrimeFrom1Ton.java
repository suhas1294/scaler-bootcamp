package _03_advance._2022_04_01.prime_numbers.live_session;

import java.util.Arrays;

// Given n, get all primes from 1 to n
public class _01_PrimeFrom1Ton {
    // much more optimized. tc: O(root n * log (log n))
    public static int getAllPrime2(int n){
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
        // all the p[i] which is true is a prime number
        int primeCount = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i]) primeCount++;
            System.out.println(p[i]);
        }
        return primeCount;
    }

    // tc: O(n * log (log n))
    public static int getAllPrime(int n){
        boolean[] p = new boolean[n+1];
        Arrays.fill(p, true);
        p[0] = p[1] = false;
        for (int i = 2; i <= n ; i++) {
            if (p[i]){
                for (int j = 2*i; j <= n; j++) {
                    p[j] = false;
                }
            }
        }
        // all the p[i] which is true is a prime number
        int primeCount = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i]) primeCount++;
            System.out.println(p[i]);
        }
        return primeCount;
    }
}

/*
n = 20, ans : 2 3 5 7 11 13 17 19

bruteforce : for all numbers from 1 to n, check if its prime or not and print it. tc: O(n root n)


 */

