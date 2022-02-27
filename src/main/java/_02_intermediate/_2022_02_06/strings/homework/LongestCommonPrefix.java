package _02_intermediate._2022_02_06.strings.homework;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] A) {
        if (A.length == 1) return A[0];
        String curCommonPrefix = "";
        if (A.length > 1){
            curCommonPrefix = findCommonSubstring(A[0], A[1]);
        }
        for (int i = 1; i < A.length; i++) {
            String common = findCommonSubstring(A[i], curCommonPrefix);
            System.out.println(common);
            if (common.isEmpty()) return "";
            if (curCommonPrefix.length() > common.length()){
                curCommonPrefix = common;
            }
        }
        return curCommonPrefix;
    }

    public static String findCommonSubstring(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while ( (i < Math.min(s1.length(), s2.length())) &&(s1.charAt(i) == s2.charAt(i))){
            sb.append(s1.charAt(i));
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(longestCommonPrefix(new String[]{"abab", "ab", "abcd"}));
        //System.out.println(longestCommonPrefix(new String[]{"abcd", "abcd", "efgh"}));
        System.out.println(longestCommonPrefix(new String[]{
                "aaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"}));
    }
}

/*
Given the array of strings A, you need to find the longest string S which is the prefix
of ALL the strings in the array.
Longest common prefix for a pair of strings S1 and S2 is the longest string
S which is the prefix of both S1 and S2.
For Example: longest common prefix of "abcdefgh" and "abcefgh" is "abc".

0 <= sum of length of all strings <= 1000000

input format: The only argument given is an array of strings A.
output format: Return the longest common prefix of all strings in A.

Input 1: A = ["abcdefgh", "aefghijk", "abcefgh"], output : "a"
exp: Longest common prefix of all the strings is "a".

Input 2: A = ["abab", "ab", "abcd"]; output: "ab"
exp: Longest common prefix of all the strings is "ab".

 */