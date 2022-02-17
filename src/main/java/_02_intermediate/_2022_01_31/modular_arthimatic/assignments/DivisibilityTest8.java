package _02_intermediate._2022_01_31.modular_arthimatic.assignments;

public class DivisibilityTest8 {
    public int solve(String A) {
        try{
            if((Integer.parseInt(A) % 8) == 0) return 1;
        }catch (NumberFormatException nfe){
            int n = Integer.parseInt(A.substring(A.length() - 3));
            if((n % 8) == 0) return 1;
        }
        return 0;
    }
}
/*
Given a number A in the form of string. Check if the number is divisible by 8 or not.
Return 1 if it is divisible by 8 else return 0.

The only argument given is string A.
Return 1 if it is divisible by 8 else return 0.

1 <= length of the String <= 100000
'0' <= A[i] <= '9'

Input 1:
    A = "16"
Output 1:
    1

Input 2:
    A = "123"
Output 2:
    0
 */
