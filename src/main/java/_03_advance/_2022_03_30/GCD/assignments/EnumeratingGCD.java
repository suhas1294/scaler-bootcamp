package _03_advance._2022_03_30.GCD.assignments;

// you can not store 10^100 in long and you don’t need to store that also you just have
// to check THE STRING GIVEN are equal or not if they are equal then the gcd is either
// of the 2 number otherwise the answer is 1

public class EnumeratingGCD {
    public static String solve(String A, String B) {
        if(A.equals(B))
            return A;
        else
            return "1";
    }
}

/*
You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B
inclusive is taken (GCD(A, A+1, A+2 ... B)).
As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.
You have to return the value of GCD found.
The greatest common divisor of 2 numbers, A and B, is the largest number, D that
divides both A and B perfectly.

constrints: 1 <= A <= B <= 10^100

Input Format: First argument is a string denoting A,Second argument is a string denoting B.
Output Format : Return a string which contains the digits of the integer which
represents the GCD. The returned string should not have any leading zeroes.

Example Input : A = "1" , B = "3"
Example Output : 1

Example Explanation : Greatest divisor that divides both 1 and 3 is 1.
 */