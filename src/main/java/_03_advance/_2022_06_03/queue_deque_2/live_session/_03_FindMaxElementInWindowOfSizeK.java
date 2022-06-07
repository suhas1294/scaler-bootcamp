package _03_advance._2022_06_03.queue_deque_2.live_session;

import java.util.*;

public class _03_FindMaxElementInWindowOfSizeK {
    public static List<Integer> getMaxEleInWindow(int[] a, int k){
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int start = 0; // To keep track of valid ele in que we can Keep inde

        // for first window.
        for (int i = 0; i < k; i++) {
            while (dq.size() > 0 && a[i] > a[dq.getLast()]){
                dq.removeLast(); // pop back
            }
            dq.addLast(i); // push back
        }

        ans.add(a[dq.peekFirst()]); //  front
        start++;

        // for rest of the windows.
        for (int i = k; i < a.length; i++) {
            while (dq.size() > 0 && a[i] > a[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if (start > dq.peekFirst()) dq.removeFirst();
            ans.add(a[dq.peekFirst()]);
            start++;
        }
        return ans;
    }
}

/*
Given an array of integers A. There is a sliding window of size B, moving from the
very left of the array to the very right. You can only see the B numbers in the window.
Each time the sliding window moves rightwards by one position. You have to find the maximum
for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.



Problem Constraints
1 <= |A|, B <= 10⁶

Input Format : The first argument given is the integer array A.
The second argument given is the integer B.

Output Format :
Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

Input 1: A = [1, 3, -1, -3, 5, 3, 6, 7] B = 3, Output 1: [3, 3, 5, 5, 6, 7]
Input 2: A = [1, 2, 3, 4, 2, 7, 1, 3, 6] B = 6, Output 2: [7, 7, 7, 7]

Explanation 1:
 Window position     | Max
 --------------------|-------
 [1 3 -1] -3 5 3 6 7 | 3
 1 [3 -1 -3] 5 3 6 7 | 3
 1 3 [-1 -3 5] 3 6 7 | 5
 1 3 -1 [-3 5 3] 6 7 | 5
 1 3 -1 -3 [5 3 6] 7 | 6
 1 3 -1 -3 5 [3 6 7] | 7

Explanation 2:
 Window position     | Max
 --------------------|-------
 [1 2 3 4 2 7] 1 3 6 | 7
 1 [2 3 4 2 7 1] 3 6 | 7
 1 2 [3 4 2 7 1 3] 6 | 7
 1 2 3 [4 2 7 1 3 6] | 7
 */