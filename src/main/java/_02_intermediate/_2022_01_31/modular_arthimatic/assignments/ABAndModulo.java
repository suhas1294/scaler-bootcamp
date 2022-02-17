package _02_intermediate._2022_01_31.modular_arthimatic.assignments;

public class ABAndModulo {
    public int solve(int A, int B) {
        return Math.abs(A-B);
    }
}

/*
Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.
1 <= A, B <= 10^9
A != B

The first argument given is the integer, A.
The second argument given is the integer, B.
Return an integer denoting greatest possible positive M.

input 1: A = 1 B = 2, output : 1, explanation: 1 is the largest value of M such that A % M == B % M.

input 2: A = 5 B = 10, output : 5
explanation:For M = 5, A % M = 0 and B % M = 0. No value greater than M = 5, satisfies the condition.
 */