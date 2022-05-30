package mentor_session._2022_02_09.mock_interview;

public class ParkingSlot {
    public static int solve(int[] a, int k){
        int start = 0, end = start, window_len = 0;
        while (end < a.length){
            while (window_len < k /*a[end] != 0*/){
                end++;
                if (a[end] == 0) window_len++;
                if (window_len == k) {
                    window_len = Math.min(window_len, end-start+1);
                }
                start++;
                window_len--;
                while (a[start] != 0){
                    start++;
                    window_len--;
                }
            }
            end++;
        }
        return window_len;
    }
}

/*
you have been given binary array a[] where a[i] represents availability of parking slots.
and you have been given integer k which represents number of cars which you need to park.
you need to park in such a way that the distance between extreme positions of car(which
you are parking) should be minimum.

Minimum number of parking slots required to park k cars.

                 S   e
Arr [0 0 1 0 0 1 0 0 0]
0 - empty parking slot
1-  Piller / occupied
K = Number of cars which you need to park
Q:  find the minimum parking slots required to park k cars

k = 3
[X X 1 X 0 1 0 0 0 ]
[0 X 1 X X 1 0 0 0 ]
[0 0 1 0 0 1 X X X ]

k = 5
[0 0 1 X X 1 X X X ]

         e
     s
//[0 0 1 0 0 1 0 0 0]

Question Summary:
length of the longest sub array of 0's with the least number of 1s,
sub array length excluding 1's should be equal to k (there should be k zeros)

edge case: what if array contains only 1's

Related problem :
1. https://www.interviewbit.com/blog/largest-subarray-of-0s-and-1s/
2. https://leetcode.com/problems/max-consecutive-ones-iii/discuss/247650/longest-contiguous-subarray-with-at-most-k-zeros
 */