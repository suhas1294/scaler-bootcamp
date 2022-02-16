package _02_intermediate._2022_01_26.bit_manipulation.homework;

import java.util.Arrays;

public class SingleNumberIII {
    public static int[] solve(int[] A) {
        // step-1 : xor all elements and get the result and store it in variable
        int xor_arr = A[0];
        for (int i = 1; i < A.length; i++) {
            xor_arr = xor_arr ^ A[i];
        }

        // step-2 : take 2's compliment of prev step result
        // this is to get right most set bit of answer.
        xor_arr = (xor_arr & -xor_arr);

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < A.length; i++) {
            if ((A[i] & xor_arr) > 0) {
                sum1 = (sum1 ^ A[i]);
            }else {  // if result == 0 then arr[i] xored with sum2
                sum2 = (sum2 ^ A[i]);
            }
        }
        int[] result = new int[]{sum1, sum2};
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solve(new int[]{1, 2, 3, 1, 2, 4})));
        System.out.println(Arrays.toString(solve(new int[]{2308, 1447, 1918, 1391, 2308, 216,
                1391, 410, 1021, 537, 1825, 1021, 1729, 669,
                216, 1825, 537, 1995, 805, 410, 805, 602,
                1918, 1447, 90, 1995, 90, 1540, 1161,
                1540, 2160, 1235, 1161, 602, 880, 2160, 1235, 669}))); // expected: 880 1729
    }
}

/*
Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice.
Find the two elements that appear only once.
Note: Output array must be sorted.

2 <= |A| <= 100000
1 <= A[i] <= 10^9

input format: First argument is an array of interger of size N.
output format: Return an array of two integers that appear only once.

input 1 : A = [1, 2, 3, 1, 2, 4], output : [3, 4], explanation: 3 and 4 appear only once.
input 1 : A = [1, 2], output : [1, 2], explanation: 1 and 2 appear only once.

soln:
Step 1: Xor all the elements of the array into a variable sum thus all the elements present twice in an array will get removed as for example, 4 = “100” and if 4 xor 4 => “100” xor “100” thus answer will be “000”.
Step 2: Thus in the sum the final answer will be 3 xor 5 as both 2 and 4 are xor with itself giving 0, therefore sum = “011” xor “101” i.e sum = “110” = 6.
Step 3: Now we will take 2’s Complement of sum i.e (-sum) = “010”.
Step 4: Now bitwise And the 2’s of sum with the sum i.e “110” & “010” gives the answer “010” (Aim for bitwise & is that we want to get a number that contains only the rightmost set bit of the sum).
Step 5: bitwise & all the elements of the array with this obtained sum, 2 = “010” & “010” = 2, 3 = “011” & “010” = “010” , 4 = “100” & “010” = “000”, 5 = “101” & “010” = “000”.
Step 6: As we can see that the bitwise & of 2,3 > 0 thus they will be xor with sum1 and bitwise & of 4,5 is resulting into 0 thus they will be xor with sum2.
Step 7: As 2 is present two times so getting xor with sum1 two times only the result 3 is being stored in it and As 4 is also present two times thus getting xor with sum2 will cancel it’s value and thus only 5 will remain there.
 */