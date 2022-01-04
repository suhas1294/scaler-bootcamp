package _01_beginner._2021_12_17.assignment;

/*
You are given two character strings A and B.
You have to find the first occurrence of string B in string A, as a substring, and
return the starting position of first occurrence.
A substring is a contiguous sequence of characters within a string.
For e.g "at" is a substring in "catalogue".

1 <= |A|, |B| <= 1000
A[i], B[i] ∈ ['a'-'z']

input format:
First argument is a character string A.
Second argument is a character string B.

output format:
Return an integer denoting the starting position of first occurrence, or return -1 to
report that there is no such occurrence.

input 1:
    A = "aabababaa"
    B = "ba"
output : 3
Substrings A[3..4], A[5..6] and A[6..7] are equal to B = "ba".
First occurrence is substring A[3..4] having starting position = 3.

input 2:
    A = "abc"
    B = "ac"
output : -1
"ac" does not exist as a substring in "abc".
*/
public class FirstOccurenceOfAWord {
    public static void main(String[] args) {
        //System.out.println(solve("aabababaa", "ba"));
        System.out.println(solve("abc", "ac"));
    }
    public static int solve(String A, String B) {
        int occ_index =  A.indexOf(B);
        occ_index = occ_index == -1 ? -1 : occ_index + 1;
        return occ_index;
    }
}
