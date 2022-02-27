package _02_intermediate._2022_02_06.strings.homework;

public class ChangeCharacter {
    //public static int solve(String A, int B) {
    //}
}

/*
Given a string A of size N consisting of lowercase alphabets.
You can change at most B characters in the given string to any other lowercase alphabet
such that the number of distinct characters in the string is minimized.
Find the minimum number of distinct characters in the resulting string.

1 <= N <= 100000
0 <= B < N

input format: First argument is a string A. Second argument is an integer B.
output format: Return an integer denoting the minimum number of distinct characters in the string.

ex: input : A = "abcabbccd" B = 3, output : 2
exp: We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
So the minimum number of distinct character will be 2.
 */