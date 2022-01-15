package _02_intermediate._2022_01_14.carry_forward.assignments;

public class SpecialSubSequenceCharAG {
    public static int solve(String A) {
        char[] charArray = A.toCharArray();
        int gCount = 0, answer = 0;
        for (int i = charArray.length-1; i >=0; i--) {
            if (charArray[i] == 'G') {
                gCount++;
                continue;
            }else if(charArray[i] == 'A'){
                answer += gCount;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //String input = "ABCGAG";
        String input = "GAB";
        System.out.println(solve(input));
    }
}

/*
You have given a string A having Uppercase English letters.
You have to find that how many times subsequence "AG" is there in the given string.
NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.

constraints:
1 <= length(A) <= 10^5

input format: First and only argument is a string A.
output format: Return an integer denoting the answer.

input 1:  A = "ABCGAG", output : 3,  Subsequence "AG" is 3 times in given string
input 2 :  A = "GAB", output : 0,  There is no subsequence "AG" in the given string.

 */