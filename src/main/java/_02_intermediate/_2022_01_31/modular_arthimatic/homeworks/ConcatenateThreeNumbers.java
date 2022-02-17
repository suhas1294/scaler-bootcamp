package _02_intermediate._2022_01_31.modular_arthimatic.homeworks;

public class ConcatenateThreeNumbers {
    public int solve(int A, int B, int C) {
        int least = Math.min(A, Math.min(B, C));
        String ans = "";
        if (A == least){
             ans = A + "" + Math.min(B, C) + "" + Math.max(B, C);
        }else if(B == least){
            ans = B + "" + Math.min(A, C) + "" + Math.max(A, C);
        }else{
            ans = C + "" + Math.min(B, A) + "" + Math.max(B, A);
        }
        return Integer.parseInt(ans);
    }
}

/*
Given three 2-digit integers, A, B and C, find out the
minimum number that can be obtained by concatenating them in any order.
Return the minimum result that can be obtained.

10 <= A, B, C <= 99

The first argument of input contains an integer, A.
The second argument of input contains an integer, B.
The third argument of input contains an integer, C.

Return an integer, representing the answer.

Input 1: A = 10 B = 20 C = 30, output : 102030, exp: 10 + 20 + 30 = 102030
Input 2: A = 55 B = 43 C = 47, output: 434755 , exp: 43 + 47 + 55 = 434755
 */
