package _03_advance._2022_04_13.sorting_2.assignments;

import java.util.ArrayList;
import java.util.List;

// same question as src/main/java/_02_intermediate/_2022_02_04/sorting/homework/LargestNumber.java
public class FormLargestNoFromArray {
    public String largestNumber(final int[] A) {
        List<String> temp = new ArrayList<>();
        for (Integer x : A) temp.add(String.valueOf(x));
        temp.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));
        String ans = String.join("", temp);
        return ans.charAt(0) == '0' ? "0" : ans.toString();
    }
}
/*
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

Problem Constraints
    1 <= len(A) <= 100000
    0 <= A[i] <= 2*10^9

Input Format : The first argument is an array of integers.
Output Format :  Return a string representing the largest number.

Input 1: A = [3, 30, 34, 5, 9], Output 1: "9534330"
Explanation 1: Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

Input 2: A = [2, 3, 9, 0], Output 2: "9320"
Explanation 2: Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.
 */