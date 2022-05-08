package _03_advance._2022_04_01.prime_numbers.assignments;

import _03_advance._2022_04_01.prime_numbers.live_session._02_SmallestPrimeFactor1ton;
import java.util.*;

// combination of (for all numbers in 1 to n, get all prime till n)
// and (for all numbers from 1 to n, get prime divisors for each number)
public class LuckyNumbers {
    public static int solve(int A) {
        int[] spf = _02_SmallestPrimeFactor1ton.getAllSPF(A);
        boolean[] primeTillN = getAllPrime(A);
        List<Integer> luckNoList = new ArrayList<>();

        for (int i = 1; i <= A; i++) {
            Map<Integer, Integer> factorsWithFreq = new HashMap();
            int x = i;
            while (x > 1) {
                if (factorsWithFreq.containsKey(spf[x])) {
                    int curCnt = factorsWithFreq.get(spf[x]);
                    factorsWithFreq.put(spf[x], curCnt + 1);
                } else {
                    factorsWithFreq.put(spf[x], 1);
                }
                x = x / spf[x];
            }
            int primeDivisorCnt = 0;
            for (Integer value : factorsWithFreq.keySet()) {
                if (primeTillN[value]) primeDivisorCnt++;
                if (primeDivisorCnt > 2) break;
            }
            if (primeDivisorCnt == 2) luckNoList.add(i);
        }
        return luckNoList.size();
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

    public static void main(String[] args) {
        System.out.println(solve(8)); // 1
    }
}

/*
A lucky number is a number that has exactly 2 distinct prime divisors.
You are given a number A, and you need to determine the count of lucky numbers
between the range 1 to A (both inclusive).

Problem Constraints : 1 <= A <= 50000

Input Format : The first and only argument is an integer A.
Output Format : Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.

Input 1: A = 8 , output : 1
Input 2: A = 12, output : 3

Explanation 1:
Between [1, 8] there is only 1 lucky number i.e 6.
6 has 2 distinct prime factors i.e 2 and 3.

Explanation 2:
Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */