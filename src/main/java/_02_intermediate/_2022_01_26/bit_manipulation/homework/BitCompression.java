package _02_intermediate._2022_01_26.bit_manipulation.homework;

public class BitCompression {
    public static int compressBits(int[] A) {
        for (int i = 0, j = i+1; j < A.length; i++, j++) {
            int andResult = A[i] & A[j];
            int orResult = A[i] | A[j];
            A[i] = andResult;
            A[j] = orResult;
        }
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result = result ^ A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        //compressBits(new int[]{1,3, 5});
         compressBits(new int[]{1, 5, 6, 7, 9});
    }
}

/*
Richard Hendricks, a mastermind on compression algorithms, in an employee of Hooli in the Silicon Valley.
One day, he finally decided to quit and work on his new idea of middle - out algorithm.

He needed to work at the bit - level to compress data. He, eventually, encountered this problem.
There was an array A of N integers. He had to perform certain operations on the elements.
In any one operation, two indices i and j (i < j) are chosen, and A[i] is replaced with A[i] & A[j],
and A[j] is replaced with A[i] | A[j], where & represents the Bitwise AND operation and | represents the Bitwise OR operation.
This operation is performed over all the pairs of integers in the array.

Help Richard find the Bitwise XOR of all the elements after performing the operations.
1 <= N <= 10^5
1 <= Ai <= 10^9

input format: The first argument is the integer array A.
output format: Return a single integer denoting the XOR of the elements after performing the operations.

Input 1: A = [1, 3, 5], output : 7
explanation: After performing the operations, the array becomes [1, 1, 7].
The XOR of all the elements of this array is 7.
There can be other arrays too but we can prove that the XOR will always be 7.

Input 2: A = [1, 1, 1], output : 1
explanation: Since, all the elements are equal.
Even, after applying the operations, the array will be [1, 1, 1].
The XOR of all the elements of this array is 1.
 */