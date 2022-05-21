package _03_advance._2022_04_27.binary_search_4.live_session;

import _03_advance._2022_03_30.GCD.live_session._01_EuclideanGCD;

public class _01_AthMagicPrerequisite {
    // PREREQUISITE-1, see formula below
    public static int getLCM(int a, int b){
        return ((a * b) / _01_EuclideanGCD.getGCD(a,b));
    }

    // PREREQUISITE-2
    //(A union B) = A + B - (A intersection B)

    // PREREQUISITE-3
    // given A & B, find multiples of A from 1 to B i.e., [1-B]
    // ans : B / A

    // PREREQUISITE-4
    // given A, B,and C, fund no of multiples of B or C from [1-A]
    // ans : A/B + A/C + A/LCM(B,C)  : refer notes for explanation,
    // we do A/LCM(B,C) to get number of repeating factors from both B and C
}

/*
Given 2 numbers, A and B, find LCM(A,B)
formula  : LCM(A,b) = (A * B) / GCD(A*B)
 */