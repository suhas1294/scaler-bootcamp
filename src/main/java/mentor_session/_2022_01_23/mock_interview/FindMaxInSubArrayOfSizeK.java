package mentor_session._2022_01_23.mock_interview;

import java.util.*;

public class FindMaxInSubArrayOfSizeK {
    // optimized solution using Dqueue, tc: O(n)
    public static ArrayList<Integer> solve(int[] arr, int k){
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<Integer>();

        int we;
        for (we = 0; we < k; ++we) {
            // For every element, the previous smaller elements are useless so remove them from dq
            while (!dq.isEmpty() && arr[we] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(we); // Add new element at rear of queue
        }

        for (; we < arr.length; we++){
            int ws = we-k + 1;
            result.add(arr[dq.peek()]); // element at the front of the queue is the largest element

            // Remove the elements which are out of this window
            while ((!dq.isEmpty()) && dq.peek() < ws) {
                dq.removeFirst();
            }

            // Remove all elements smaller than the currently being added element
            while ((!dq.isEmpty()) && arr[we] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(we); //current element
        }
        result.add(arr[dq.peek()]); // maximum element of last window
        return result;
    }


    // sub-optimized solution using priority queue, tc: n log k
    public static ArrayList<Integer> solve2(int[] arr, int k){
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> result = new ArrayList<>();
        int si = 0;
        for (int ei = 0; ei < arr.length; ei++) {
            pq.add(arr[ei]);
            if (ei - si + 1 == k){ // if window size exceeds K, then move si
                int maxEle = pq.peek();
                result.add(maxEle);
                if (maxEle == arr[si]){
                    pq.remove();
                }
                si++;
            }
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
        // System.out.println(solve(new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6}, 3));
        System.out.println(solve(new int[]{1, 2, 3, 1, 1, 1, 4, 5, 2, 3, 6}, 3));
    }
}
