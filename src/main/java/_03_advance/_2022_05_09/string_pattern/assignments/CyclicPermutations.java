package _03_advance._2022_05_09.string_pattern.assignments;

public class CyclicPermutations {
    public static int solve(String A, String B) {
        StringBuilder builder = new StringBuilder();
        builder.append(A);
        builder.append("|");
        builder.append(B);
        builder.append(B.substring(0, B.length()-1));
        int[] lps = generateLPS(builder.toString());
        int count = 0;
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == A.length()) {
                count++;
            }
        }
        return count;
    }

    private static int[] generateLPS(String A) {
        int[] L = new int[A.length()];
        int i = 1, j = 0;
        while (i < A.length()) {
            if (A.charAt(i) == A.charAt(j)) {
                L[i++] = ++j;
            } else {
                if (j == 0) {
                    L[i++] = 0;
                } else {
                    j = L[j-1];
                }
            }
        }
        return L;
    }

    public static void main(String[] args) {
        System.out.println(solve("1010", "1010"));
    }

}

/*
Given two binary strings A and B, count how many cyclic permutations of B
when taken XOR with A give 0.

(Read it as S subscript k)
NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic permutation is of the
form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.

Problem Constraints
1 ≤ length(A) = length(B) ≤ 10^5

Input Format:
The first argument is a string A.
The second argument is a string B.

Output Format :  Return an integer denoting the required answer.

Input 1: A = "1001" B = "0011", Output 1: 1
Explanation 1:
 4 cyclic permutations of B exists: "0011", "0110", "1100", "1001".
 There is only one cyclic permutation of B i.e. "1001" which has 0 xor with A.

Input 2: A = "111" B = "111", Output 2: 3
Explanation 2:
 All cyclic permutations of B are same as A and give 0 when taken xor with A. So, the ans is 3.
 */