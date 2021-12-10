package beginner._2021_12_08.homeworks;

import beginner._2021_12_10.live_class.DecToBin;

/**
 * Given an integer A, find and return the Ath magic number.
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), …. REFER IMAGE ATTACHED
 * 1 <= A <= 5000
 * Input format : The only argument given is integer A.
 * output format : Return the Ath magic number.
 * ex : input A = 1 ; output : 30 ; explanation :  A in increasing order is [5, 25, 30, 125, 130, ...] 3rd element in this is 30
 * ex : input A = 10 ; output : 650 ; explanation : In the sequence shown in explanation 1, 10th element will be 650.
 *
 */
public class NthMagicNumber {
    public static void main(String[] args) {
        System.out.println(solve(10));
        System.out.println(decToBase5(10));
    }

    public static int solve(int A) {
        int[] result = new int[A];
        int outerLoop = (int)Math.floor(Math.sqrt(A));
        int pointer = 0;
        for (int i = 0; i <= outerLoop; i++) {
            for (int j = 0; j <= (int)Math.pow(2, i)-1 ; j++) {
                if (pointer > A-1 ) break;
                if (j == 0){
                    result[pointer] = (int)Math.pow(5, i+1);
                }else{
                    result[pointer] =  (int)Math.pow(5, i+1) + result[j-1];
                }
                pointer++;
            }
        }
        return result[A-1];
    }

    // More optimized solution without using any array
    private static int decToBase5(int n){
        int p = 5;
        int ans = 0;
        while (n > 0){
            int rem = n % 2;
            ans = ans + rem * p;
            p *= 5;
            n = n/2;
        }
        return ans;
    }
}
