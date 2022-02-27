package _02_intermediate._2022_02_06.strings.assignments;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String A) {
        String[] arr = A.split("");
        int maxLen = 1;

        for (int i = 0; i < arr.length-1; i++) {
            if ((A.length()%2 == 0) && arr[i].equals(arr[i+1])){ // even palindrome
                maxLen = Math.max(maxLen, expand(arr, i, i+1));
            }else{ // odd palindrome
                maxLen = Math.max(maxLen, expand(arr, i, i));
            }
        }
        System.out.println(maxLen);
        return "";
    }

    public static int expand(String[] arr, int i, int j){
        while (arr[i].equals(arr[j]) && i > 0 && j < arr.length){
            i--;
            j++;
        }
        return j-i-1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
    }
}

/*
Given a string A of size N, find and return the longest palindromic substring in A.
Substring of string A is A[i...j] where 0 <= i <= j < len(A)
Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
Incase of conflict, return the substring which occurs first ( with the least starting index).

1 <= N <= 10000

input format: First and only argument is a string A.
output format: Return a string denoting the longest palindromic substring of string A.

input : A = "aaaabaaa", output: "aaabaaa"
explanation: We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */