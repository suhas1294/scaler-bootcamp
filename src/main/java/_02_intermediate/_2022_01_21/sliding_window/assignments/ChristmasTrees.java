package _02_intermediate._2022_01_21.sliding_window.assignments;

import utils.Util;
import java.util.ArrayList;

public class ChristmasTrees {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() < 3) return -1;

        if (A.size() == 3) {
            int sum = 0;
            for (Integer num: B ) {
                sum += num;
            };
            return sum;
        }

        int leastCost = Integer.MAX_VALUE ;

        for (int j = 0; j < B.size(); j++) {
            int leastLeftSum = Integer.MAX_VALUE, leastRightSum = Integer.MAX_VALUE ;

            // search for least element then a[j] in first half array
            for (int i = 0; i < j; i++) {
                if (A.get(i) < A.get(j)){
                    leastLeftSum = Math.min(leastLeftSum, B.get(i));
                }
            }
            // search for higher element then a[j] but least among other in second half array
            for (int k = j+1 ; k < B.size(); k++) {
                if (A.get(k) > A.get(j)){
                    leastRightSum = Math.min(leastRightSum, B.get(k));
                }
            }

            if (leastLeftSum != Integer.MAX_VALUE && leastRightSum != Integer.MAX_VALUE){
                leastCost = Math.min(leastCost, leastLeftSum + leastRightSum + B.get(j));
            }
        }
        if (leastCost == Integer.MAX_VALUE) return -1;
        return leastCost;
    }

    public static void main(String[] args) {
        System.out.println(
                solve(
                    Util.arrayToList(new int[]{5, 9, 10, 4, 7, 8 }),
                    Util.arrayToList(new int[]{5, 6, 4, 7, 2, 5})
                ));
    }
}

/*
soln credits: https://www.geeksforgeeks.org/minimum-cost-of-choosing-3-increasing-elements-in-an-array-of-size-n/
You are given an array A consisting of heights of Christmas trees, and an array B of same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q and r), such that Ap < Aq < Ar, where p < q < r.
The cost of these trees is Bp + Bq + Br.
You are to choose 3 such trees, so they have the minimum cost and find the minimum cost.
If not possible to choose 3 such trees, return -1.

1 <= A[i], B[i] <= 109
3 <= size(A) = size(B) <= 3000

input format:
First argument is an integer array A.
Second argument is an integer array B.

output format:
Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order, if not possible, -1.

Input 1:
 A = [1, 3, 5]
 B = [1, 2, 3]
output: 6
We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.

Input 2:
 A = [1, 6, 4, 2, 6, 9]
 B = [2, 5, 7, 3, 2, 7]
output : 7

Input 3:
 A : [ 5, 9, 10, 4, 7, 8 ]
 B : [ 5, 6, 4, 7, 2, 5 ]
output : 12

 */