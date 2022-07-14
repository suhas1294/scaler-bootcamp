package _03_advance._2022_07_04.heaps_2.live_session;

import java.util.Collections;
import java.util.PriorityQueue;

public class _02_MedianOfPrefixSubArrays {
    // first half AKA first dabba is max Heap, second dabba is min heap
    int[] runningMedian(int a[]){
        int n = a.length;
        int[] ans = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(a[0]);
        ans[0] = a[0];

        for (int i = 1; i < n; i++) {
            // step-1 : insert a[i]
            if (a[i] < maxHeap.peek()){
                maxHeap.add(a[i]); // a[i] belongs to first half
            }else{
                minHeap.add(a[i]);
            }
            // step-2 : balancing heaps
            if (maxHeap.size() < minHeap.size()){
                // transfer min element from min heap to max heap
                int ele = minHeap.peek(); // minHeap.getMin()
                minHeap.remove(); // minHeap.delete_min()
                maxHeap.add(ele);
            }else if (maxHeap.size() - minHeap.size() > 1){
                // transfer max from maxHeap to minheap
                int ele = maxHeap.peek(); // maxHeap.getMax()
                maxHeap.remove(); // maxHeap.deleteMax()
                minHeap.add(ele);
            }
            int s = i + 1; // s is total elements inserted in both heaps.
            // step-3 : calculating median
            if (s % 2 == 0){
                ans[i] = (maxHeap.peek() + minHeap.peek())/2; // (maxHeap.getMax + minHeap.getMin)/2
            }else{
                ans[i] = maxHeap.peek(); // maxheap.getmax()
            }
        }
        return ans;
    }
}

/* given an array, find median of all prefix sub arrays
 meaning of prefix subarrays : sub arrays starting at index 0
 ex : {9,6,3,10, 4}
 prefix sub arrays      median
 9                      9
 9,6                    (6+9)/2
 9,6,3                  6
 9,6,3,10               (6+9)/2 (sort inorder and then take median)
 9,6,3,10,4             6

 idea-1 : sort every prefix sub array and get median, tc : nlogn, sc : O(n)
 idea-2 : after each step in insertion sort, for prefix sub array get median., tc: O(n²), sc:O(1)
 idea-3 : take two containers - one min heap and one max heap and fulfill following observations:
        If we divide the array into two halves, then
            1. max element in 1st < min element in second half
            2. size of first half - size of second half <= 1
            3. max element in 1st half if array length is odd
*/
