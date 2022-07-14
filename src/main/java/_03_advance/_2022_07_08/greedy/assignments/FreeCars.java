package _03_advance._2022_07_08.greedy.assignments;

import java.util.*;

public class FreeCars {

    class Pair {
        int deadline;
        int profit;

        Pair(int d, int p) {
            this.deadline = d;
            this.profit = p;
        }
    }

    public int solve(int[] A, int[] B) {
        Pair p[] = new Pair[A.length];
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < A.length; i++) {
            p[i] = new Pair(A[i] - 1, B[i]);
        }
        Arrays.sort(p, (p1, p2) -> {
            if (p1.deadline < p2.deadline) {
                return -1;
            }
            return 1;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0, day = -1;
        for (int i = 0; i < A.length; i++) {
            if (day < p[i].deadline) {
                day++;
                pq.add(p[i].profit);
                ans = (ans % mod + p[i].profit % mod) % mod;
            } else {
                if (p[i].profit > pq.peek()) {
                    int min = pq.poll();
                    ans = (ans % mod - min % mod + mod) % mod;
                    pq.add(p[i].profit);
                    ans = (ans % mod + p[i].profit % mod) % mod;
                }
            }
        }
        return ans;
    }

    // ----------- alternate solution ----------------
    public int solve2(int[] A, int[] B) {
        ArrayList<Node> list = new ArrayList<Node>();
        for (int i = 0; i < A.length; i++) {
            list.add(new Node(A[i], B[i]));
        }
        Collections.sort(list, new CustomComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int time = 0;
        for (int i = 0; i < A.length; i++) {
            if (time <= list.get(i).time - 1) {
                minHeap.add(list.get(i).profit);
            } else {
                time--;
                if (minHeap.peek() < list.get(i).profit) {
                    minHeap.poll();
                    minHeap.add(list.get(i).profit);
                }
            }
            time++;
        }
        long ans = 0, m = (1000 * 1000 * 1000) + 7;
        while (!minHeap.isEmpty()) {
            //System.out.println(minHeap.peek()+"xx");
            ans += minHeap.poll();
            ans %= m;
        }
        return (int) ans;
    }

    class Node {
        int time;
        int profit;

        public Node(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }
    }

    class CustomComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.time - b.time;
        }
    }
}

/*
Given two arrays, A and B of size N. A[i] represents the time by which you
can buy the ith car without paying any money.B[i] represents the profit you can
earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy
the ith car when the current time <= A[i] - 1.
Your task is to find the maximum profit one can earn by buying cars considering
that you can only buy one car at a time.

NOTE:
You can start buying from time = 0.
Return your answer modulo 10^9 + 7.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
0 <= B[i] <= 10^9

Input Format
The first argument is an integer array A represents the deadline for buying the cars.
The second argument is an integer array B represents the profit obtained after buying the cars.

Output Format : Return an integer denoting the maximum profit you can earn.

Input 1: A = [1, 3, 2, 3, 3] B = [5, 6, 1, 3, 9], Output 1:  20
Explanation 1:
 At time 0, buy car with profit 5.
 At time 1, buy car with profit 6.
 At time 2, buy car with profit 9.
 At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
 So, total profit that one can earn is 20.

Input 2: A = [3, 8, 7, 5] B = [3, 1, 7, 19],  Output 2: 30
Explanation 2:
 At time 0, buy car with profit 3.
 At time 1, buy car with profit 1.
 At time 2, buy car with profit 7.
 At time 3, buy car with profit 19.
 We are able to buy all cars within their deadline. So, total profit that one can earn is 30.
 */