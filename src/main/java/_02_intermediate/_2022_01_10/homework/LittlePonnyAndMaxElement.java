package _02_intermediate._2022_01_10.homework;

import java.util.ArrayList;

public class LittlePonnyAndMaxElement {
    public static int solve(ArrayList<Integer> A, int B) {
        int count = 0; //  count of elements which is lesser than B
        boolean isTargetPresent = false;
        for (Integer num: A) {
            if (num > B) count++;
            if( num == B) isTargetPresent = true;
        }
        if (isTargetPresent){
            return count;
        }else{
            return -1;
        }
    }
}

/*
Little Ponny is given an array, A, of N integers. In a particular operation,
he can set any element of the array equal to -1.
He wants your help for finding out the minimum number of operations required
such that the maximum element of the resulting array is B. If it is not possible then return -1.
constraints:
1 <= |A| <= 10^5
1 <= A[i] <= 10^9
input format:
The first argument of input contains an integer array, A.
The second argument of input contains an integer, B.
output format: Return an integer representing the answer.

Input 1:
 A = [2, 4, 3, 1, 5]
 B = 3
output: 2
explanation: We need to remove 4 and 5 to make 3 the biggest element.

Input 2:
 A = [1, 4, 2]
 B = 3
output: -1
explanation: As 3 doesn't exist in the array, the answer is -1.
 */