package _03_advance._2022_03_25.bit_manipulation.live_session;

import utils.Util;

// use contribution technique
public class _01_SumOfXorOfAllPairs {
    public static int sumOfXor(int[] arr){
        int sum = 0;
        for (int i = 0; i < 31; i++) {
            // for every bit position i, get no of set and unset bits in array elements
            int c = 0;
            for (int j = 0; j < arr.length; j++) {
                // count of ith bit set = c, count of ith bit unset = N-c where n = arr.len
                if (Util.checkBit(arr[j], i)) c++;
            }
            // in how many xor pairs ith bit is set = c * (n-c)
            sum = sum + (c * (arr.length-c)) * (1 << i); // 2^i = 1 << i
        }
        return 2 * sum; //  why 2 ? : because in above code we calculated for only upper triangle
    }
}

/*
given n positive elements in array, calculate (sum of xor of all pairs)
ex: {3, 1, 5}
all pairs :
    3^3, 3^1, 3^5
    1^3, 1^1, 1^5
    5^3, 5^1, 5^5

idea-1 : bruteforce solution : nested loop, for each element calculate xor of other element
idea-2 : we can ignore diagonal element as it will be 0, also ignore lower triangle
idea-3 : calculate sum for only upper triangle. -

TC: 31 * n = O(n)
sc: o(1)
 */