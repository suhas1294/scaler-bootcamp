package _02_intermediate._2022_01_31.modular_arthimatic.homeworks;

public class LeapYear {
    public static int solve(int A) {
        boolean multipleOf400 = ((A % 400) == 0);
        boolean secondCondition = ((A % 4) == 0) && ((A % 100) != 0);
        return (multipleOf400 || secondCondition) ? 1 : 0 ;
    }
}

/*
Given an integer A representing an year, Return 1 if it is a leap year else return 0.
A year is leap year if the following conditions are satisfied:
Year is multiple of 400.
Year is multiple of 4 and not multiple of 100.

1 <= A <= 10^9

First and only argument is an integer A
Return 1 if it is a leap year else return 0

Input 1 A = 2020,  output: 1,  2020 is a leap year.
Input 2: A = 1999, output: 0, 1999 is not a leap year.
 */