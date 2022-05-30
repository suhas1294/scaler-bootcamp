package _03_advance._2022_05_25.stacks_1.assignments;

import java.util.Stack;

public class RemovePairOfConsequtiveDuplicates {
    public static String removeDuplicate(String A) {
        Stack<Character> stack = new Stack<>();
        stack.push(A.charAt(A.length() - 1));

        for (int i = A.length() - 2; i >= 0; i--) {
            if (!stack.isEmpty() && A.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(A.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        removeDuplicate("acbbck");
        removeDuplicate("abckkcbam");
        removeDuplicate("ababab");
    }
}

/*
given a string, remove every pair of consequtive duplicate until there are no
consecutive duplicates.
ex: acbbck, ans : ak
ex: abckkcbam, ans : m
ex: ababab, ans : ababab

_____________
You are given a string A. An operation on the string is defined as follows:
Remove the first occurrence of the same consecutive characters. eg for a
string "abbcd", the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "acd".
Keep performing this operation on the string until there are no more
occurrences of the same consecutive characters and return the final string.

Problem Constraints : 1 <= |A| <= 100000

Input Format : First and only argument is string A.
Output Format : Return the final string.

Input 1: A = abccbc Output 1: "ac"
Input 2: A = ab Output 2: "ab"

Explanation 1:
Remove the first occurrence of same consecutive characters. eg for a string "abbc",
the first occurrence of same consecutive characters is "bb".
Therefore the string after this operation will be "ac".

Explanation 2: No removals are to be done.
 */