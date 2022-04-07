package _03_advance._2022_03_25.bit_manipulation.live_session;

import utils.Util;

public class _02_MaxAndPair {
    public static int getMaxAndPair(int[] arr){
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            // get no of elements whose ith bit set
            int c = 0;
            for (int j = 0; j < arr.length; j++) {
                if (Util.checkBit(arr[j], i)) c++;
            }
            if (c >= 2){ // there exists atleast pair which may be potential candidate
                ans = ans + (1 << i);
                // now make all other array elements (whose ith bit is unset) as 0
                for (int j = 0; j < arr.length; j++) {
                    if (!Util.checkBit(arr[j], i)) arr[j] = 0;
                }
            }
        }
        return ans;
    }
}

/*
given n array elements, choose 2 indices (i,j) such that (i != j) and get
maximum (arr[i] & arr[j])  (i.e., logical ans)
ex: input: {27, 18, 20} output: 27, 18 because other pair's and is less whereas 27 & 18 = 18
27 :  11011
18 :  10010
20 :  10100

ex2 : input : {21, 18, 24, 17} output: 17, which pair ? : 21, 17, rest pair's '&' is < 17
Note : there can be multiple pairs

soln: start observing from MSB or left most bit(to viewer) which every number contributes
more number of 1's (more then 2) that number will be eligible to become of the
number in pair(answer)

tc: 31 * (n + 1 + n) = o(n)
sc: o(1)

Actual question:
given a array, find a,b,c,s such that a&b&c&d is max
variant question: calculate how many pairs (a,b) where a&b is max.
soln: get no of non zero elements  in array  after above program say x no of non zero elements,
then the ans would be xc2 (x combination 2), i.e., no of such pairs = xc2
 */
