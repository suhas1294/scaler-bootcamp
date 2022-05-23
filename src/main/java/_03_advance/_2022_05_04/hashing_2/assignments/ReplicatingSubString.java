package _03_advance._2022_05_04.hashing_2.assignments;

import java.util.HashMap;

public class ReplicatingSubString {
    public static int solve(int A, String B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        B.chars().forEach(a -> freq.put(a, freq.getOrDefault(a, 0) + 1));
        return freq.values().stream().anyMatch(v -> v % A != 0) ? -1 : 1;
    }
}

/*
Given a string B, find if it is possible to re-order the characters of the string B so
that it can be represented as a concatenation of A similar strings.
Eg: B = aabb and A = 2, then it is possible to re-arrange the string as
"abab" which is a concatenation of 2 similar strings "ab".
If it is possible, return 1, else return -1.

Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000
All the alphabets of S are lower case (a - z)

Input Format
First argument is an integer A.
Second argument is a string B.

Output Format
Your function should return 1 if it is possible to re-arrange the characters
of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.

Input 1: A = 2 B = "bbaabb" Output 1: 1
Explanation 1: We can re-order the given string into "abbabb".

Input 2: A = 1 B = "bc" Output 2: 1
Explanation 2: String "bc" is already arranged.
 */