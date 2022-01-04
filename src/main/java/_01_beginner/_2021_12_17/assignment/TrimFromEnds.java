package _01_beginner._2021_12_17.assignment;

/**
 * You are given a character string A. You to trim(remove) both leading
 * and trailing asterisk characters('*') in the string and return the resultant string.
 * 1 <= |A| <= 105
 * A[i] ∈ ['a'-'z', '*']
 * input format: First and only argument is a character string A.
 * output format: Return a character string denoting the resultant string after trimming.
 * ex:
 * input 1 : A = "**h*e*l*lo*", output : h*e*l*l*o
 * Explanation 1: The string has 2 leading '*' and 1 trailing '*'. Removing them, the string becomes "hello".
 * input 1 : A = "noasteriskhere"  output : noasteriskhere
 * Explanation 2: As there are no leading or trailing zeros, resultant string is same as before.
 */
public class TrimFromEnds {
    public static void main(String[] args) {
        String input = "**h*e*l*lo*";
        //String input = "**rel"; // rel
        //String input = "zn*ibzv"; // zn*ibzv
        //String input = "*"; // ""
        System.out.println(solve(input));
    }
    public static String solve(String A) {
        int i = 0;
        for (; i < A.length(); i++)
            if ((A.charAt(i) > 64 && A.charAt(i) < 91) || (A.charAt(i) > 96 && A.charAt(i) < 123)) break;
        int j = A.length()-1;
        for (; j >=0 ; j--) {
            if ((A.charAt(j) > 64 && A.charAt(j) < 91) || (A.charAt(j) > 96 && A.charAt(j) < 123)) break;
        }
        A = A.substring(i, j == -1 ? A.length() : j+1);
        return A;
    }
}
