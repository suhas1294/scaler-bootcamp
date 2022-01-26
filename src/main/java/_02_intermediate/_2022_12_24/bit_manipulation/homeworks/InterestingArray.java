package _02_intermediate._2022_12_24.bit_manipulation.homework;

public class InterestingArray {
    public static String solve(int[] A) {
        int oddCount = 0, evenCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                evenCount++;
            }else {
                oddCount++;
            }
        }
        // case 1 : even count is even, odd count is even
        if (evenCount % 2 == 0 && oddCount % 2 == 0){
            return "Yes";
        }else if(evenCount % 2 == 0 && oddCount % 2 != 0){
            // case 2 : even count is even, odd count is odd
            return "No";
        }else if(evenCount % 2 != 0 && oddCount % 2 != 0){
            // case 3 : even count is odd, odd count is odd
            return "No";
        }else{
            // case 4 : even count is even, odd count is even
            return "yes";
        }
    }
}

/*
You have an array A with N elements. We have 2 types of operation available on this array :
We can split a element B into 2 elements C and D such that B = C + D.
We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?
constraints:
1 <= N <= 100000
1 <= A[i] <= 10^6

input format: The first argument is an integer array A of size N.
output format: Return "Yes" if it is possible otherwise return "No".


Input 1: A = [9, 17], output: yes
explanation:
 Following is one possible sequence of operations -
 1) Merge i.e 9 XOR 17 = 24
 2) Split 24 into two parts each of size 12
 3) Merge i.e 12 XOR 12 = 0
 As there is only 1 element i.e 0. So it is possible.

Input 2: A = [1], output: no
Explanation 2: There is no possible way to make it 0.
 */