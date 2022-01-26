package mentor_session._2022_01_23.mock_interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class FindMaxInSubArrayOfSizeK {
    // optimal solution - using deque
    public static ArrayList<Integer> solve(int[] arr, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        // step-1 : first find largest of first k elements
        int curMax = arr[0];
        int i;
        for (i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        System.out.println(dq);
        System.out.println("---");

        // step-2 :
        for (; i < arr.length; i++) {
            result.add(arr[dq.peek()]); // largest element of  previous window, so print it
            // Remove the elements which are out of this window
            while(!dq.isEmpty() && dq.peek() <= i-k){
                dq.removeFirst();
            }
            //Remove all elements smaller than the currently being added element
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            result.add(arr[dq.peek()]); // e maximum element of last window
        }
        return result;
    }

    // brute force
    // outer loop = n-k, inner loop = k, tc  : nk
    public static ArrayList<Integer> solve2(ArrayList<Integer> arr, int k){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i <= arr.size()-k; i++){
            int curMax = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++){
                curMax = Math.max(curMax, arr.get(j));
            }
            result.add(curMax);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3)); // 3 3 4 5 5 5 6
    }
}

/*
Given an array and an integer K, find the maximum for each and every contiguous subarray of size k.

Examples :
0, 1, 2, 3, 4, 5, 6, 7, 8
1, 2, 3, 1, 4, 5, 2, 3, 6


[6]                                   i
Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3
Output: 3 3 4 5 5 5 6
Explanation:
Maximum of 1, 2, 3 is 3
Maximum of 2, 3, 1 is 3
Maximum of 3, 1, 4 is 4
Maximum of 1, 4, 5 is 5
Maximum of 4, 5, 2 is 5
Maximum of 5, 2, 3 is 5
Maximum of 2, 3, 6 is 6

Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4
Output: 10 10 10 15 15 90 90
Explanation:
Maximum of first 4 elements is 10, similarly for next 4
elements (i.e from index 1 to 4) is 10, So the sequence
generated is 10 10 10 15 15 90 90
*/