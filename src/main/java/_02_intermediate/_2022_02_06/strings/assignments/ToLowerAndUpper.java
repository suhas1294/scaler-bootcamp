package _02_intermediate._2022_02_06.strings.assignments;

import java.util.Arrays;

//a-z : 97 to 122
//A-Z : 65 to 90
// to convert to lower case, just to +32

public class ToLowerAndUpper {
    public static char[] to_lower(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 65 && A[i] <= 90){
                A[i] += 32;
            }
        }
        return A;
    }

    public char[] to_upper(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 97 && A[i] <= 122){
                A[i] -= 32;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(to_lower(new char[]{'S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'})));
    }
}

/*
You are given a function to_lower() consisting of a character array A.
Convert each charater of A into lowercase character if it exists. If the lowercase of a character does not exist, it remains unmodified.
The uppercase letters from A to Z is converted to lowercase letters from a to z respectively.
Return the lowercase version of the given character array.
1 <= |A| <= 10^5
input format: Only argument is a character array A.
output format: Return the lowercase version of the given character array.


Input 1: A = ['S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y']
output 1:  ['s', 'c', 'a', 'l', 'e', 'r', 'a', 'c', 'a', 'd', 'e', 'm', 'y']
exp: All the characters in the returned array are in lowercase alphabets.

Input 2: A = ['S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0']
output 2: ['s', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0']

 */