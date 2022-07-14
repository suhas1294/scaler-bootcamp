package _03_advance._2022_07_04.heaps_2.live_session;

// given n distinct elements, find and return k number of smallest elements in array, k < n
public class _01_KthSmallestElement {
    /*
    idea-1 : in every step, iterate over array get smallest element and swap it with ith index
    repeat above process until k - This soln is nothing but selection sort algorith for k no of times.
    tc : k * n, sc : O(1)

    idea-2 : sort entire array and get first k elements
    tc : nlogn, sc : o(n) merge sort / O(1) with quick sort

    idea-3 : insert all no into min heap and apply del_min k times
    tc : n log n + {k * 1 + K * logn) = nlogn  + klogn, sc : O(n)

    idea-4 : using max heap, tc: n logk,  sc : O(k)
    step-1 : put first k elements of array into max heap.
    step-2 : start inserting elements form k+1 to n into heap
    step-3 : observe and implement following conditions:
            1. if ele > getMax(), ele can never be our answer.
            2. if ele < getMax(), it can be possibly answer, So
                1. insert ele into heap
                2. delete max from heap
     */

}
