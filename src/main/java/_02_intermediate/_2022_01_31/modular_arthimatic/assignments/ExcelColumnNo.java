package _02_intermediate._2022_01_31.modular_arthimatic.assignments;

// basically its a decimal to base 26 conversion
public class ExcelColumnNo {
    public static int titleToNumber(String A) {
        char[] arr = A.toCharArray();
        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            int asciCharNo = arr[i] % 64;
            sum += (asciCharNo * (int)Math.pow(26, arr.length-i-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZZZZZ"));
    }
}

/*
Given a column title as appears in an Excel sheet, return its corresponding column number.
1 <= length of the column title <= 5

Input a string which represents the column title in excel sheet.
Return a single integer which represents the corresponding column number.

Input 1: AB, output: 28
Input 2: ABCD, output: 19010

explanation:
 A -> 1
 B -> 2
 C -> 3
 .
 .
 Z -> 26
 AA -> 27
 AB -> 28
 */