package _03_advance._2022_07_08.greedy.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistributeCandy {
    public int candy(int[] A) {
        int[] candies = new int[A.length];
        //Give each child 1 candy
        Arrays.fill(candies, 1);

        //From Left to right :  if child to right has higher rating—>give right child 1 candy extra than no. of candies to left child
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                candies[i] = candies[i -    1] + 1;
            }
        }

        //From right to left :  if child to left has higher rating—>give left child 1 candy extra than no. of candies to right child
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int maxSum = 0;
        for (int val : candies) maxSum += val;

        return maxSum;
    }

    /*
    Step1: Initially allocate each child 1 candy.
    Step2: From Left to right:  if the child to right has a higher rating then give the right child 1 candy extra than no. of candies to the left child.
    Step3: From right to left:  if the child to left has a higher rating then give the left child 1 candy extra than no. of candies to the right child.
    Step4: Count the candies given to each child.

    Space Complexity: O(N)
    Time Complexity: O(N)
     */
    public int candy(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return 0;
        }

        int len = A.size();
        List<Integer> candies = new ArrayList<>(Collections.nCopies(len, 1));

        for (int i = 1; i < len; i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies.set(i, candies.get(i - 1) + 1);
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                candies.set(i, Math.max(candies.get(i), candies.get(i + 1) + 1));
            }
        }

        int sum = 0;
        for (int candy : candies)
            sum += candy;

        return sum;
    }
}

/*
N children are standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?

Problem Constraints
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9

Input Format : The first and only argument is an integer array A representing the rating of children.
Output Format : Return an integer representing the minimum candies to be given.

Input 1: A = [1, 2], Output 1: 3
Explanation 1:
 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Input 2: A = [1, 5, 2, 1] Output 2:7
Explanation 2: Candies given = [1, 3, 2, 1]
 */