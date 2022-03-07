package _02_intermediate._2022_02_18.subset_subsequence.assignments;

public class LittlePonnyAndSubsequence {
    public static String solve(String A) {
        return "";
    }
}

/*
Little Ponny has been given a string A, and he wants to find out the lexicographically minimum
subsequence from it of size >= 2. Can you help him?
A string a is lexicographically smaller than string b, if the first different letter
in a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because
the first different letter is 'b' and 'c' which is smaller in "abc".

1 <= |A| <= 10^5
A only contains lowercase alphabets.

Input Format : The first and the only argument of input contains the string, A.
Output Format :  Return a string representing the answer.

Input 1: A = "abcdsfhjagj"
Input 2: A = "ksdjgha"

Output 1: "aa"
Output 2: "da"

Explanation 1: "aa" is the lexicographically minimum subsequence from A.
Explanation 2: "da" is the lexicographically minimum subsequence from A.
 */