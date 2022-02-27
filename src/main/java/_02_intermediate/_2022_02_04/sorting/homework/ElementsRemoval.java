package _02_intermediate._2022_02_04.sorting.homework;

import java.util.ArrayList;
import java.util.Collections;

// Note: same as src/main/java/_02_intermediate/_2022_02_04/sorting/live_class/_01_MinCostToRemoveElements.java

public class ElementsRemoval {
    public static int solve(ArrayList<Integer> A) {
        A.sort(Collections.reverseOrder());
        int[] descArray = A.stream().mapToInt(Integer::intValue).toArray();
        int cost = 0;
        for (int i = 0; i < descArray.length; i++) {
            cost += (descArray[i] * (i+1));
        }
        return cost;
    }
}

/*
Given an integer array A of size N. In one operation, you can remove any element from the array,
and the cost of this operation is the sum of all elements in the array present before this operation.
Find the minimum cost to remove all elements from the array.

0 <= N <= 1000
1 <= A[i] <= 10^3

input format: First and only argument is an integer array A.
output format: Return an integer denoting the total cost of removing all elements from the array.
input 1:  A = [2, 1], output: 4
exp: Given array A = [2, 1]
 Remove 2 from the array => [1]. Cost of this operation is (2 + 1) = 3.
 Remove 1 from the array => []. Cost of this operation is (1) = 1.
 So, total cost is = 3 + 1 = 4.

input 2: A = [5], output: 5
exp: There is only one element in the array. So, cost of removing is 5.

 */