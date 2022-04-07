package _03_advance._2022_03_23.bit_manipulation.live_session;

import utils.Util;

public class _01_UniqueVsThrice {
    public static int findUniqueElement(int[] arr){
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            // for ith bit, get the number of set bits
            int c = 0;
            for (int j = 0; j < arr.length; j++) {
                if (Util.checkBit(arr[j], i)) c++;
            }
            if (c % 3 == 1){
                ans = ans + (1 << i); // ans += 2^i
                // alternatively, ans = ans | (1 << i);
            }
        }
        return ans;
    }
}
/*
given an array of length n, Every element repeats thrice except one element,
find that unique element
constraints:
1 <= n <= 10^6
1 <= arr[i] <= 10^9
________________
approach 1 : bruteforce  : iterative
approach 2 : frequency
approach 3 : sort the array  + iterative & check every 3, get unique element
________________
Different versions of same problem:
v1 : above problem
v2 : every element repeats thrice except one which repeats twice , in that case c % 3 == 2
v3 : every element repeats five times except one which repeats once , in that case c % 5 == 1
v4 : every element repeats five times except one which repeats twice , in that case c % 5 == 2
v5 : every element repeats five times except one which repeats thrice , in that case c % 5 == 3
v6 : every element repeats 4 times except one which comes once : xor all elements - straight forward solution

 */
