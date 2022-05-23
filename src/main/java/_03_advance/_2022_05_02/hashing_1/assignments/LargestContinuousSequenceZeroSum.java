package _03_advance._2022_05_02.hashing_1.assignments;

import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {
    public static int[] lszero(int[] A) {
        int len = A.length;
        int answer = 0;

        //Building the prefix array.
        int[] pf = new int[len];
        pf[0] = A[0];
        for (int i = 1; i < len; i++) {
            pf[i] = pf[i - 1] + A[i];
        }

        //storing the prefix array to hasmap.
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, -1);//initialize hm with 0 and -1 -> Base case.
        int l = -1; // to store the start index of the final answer.

        for (int i = 0; i < len; i++) {
            if (hm.containsKey(pf[i])) {
                int firstIndex = hm.get(pf[i]);
                int length = i - firstIndex;
                int previousAnswer = answer;
                answer = Math.max(answer, length);
                if (answer > previousAnswer) {
                    l = firstIndex+1;
                }
            } else {
                hm.put(pf[i], i);
            }
        }

        //if we got a sub-array sum as 0, build a result array and return it.
        if (answer > 0) {
            //build the result array
            int[] result = new int [answer];
            int i =0;
            while (i<answer){
                result[i] = A[l+i];
                i++;
            }
            return result;
        } else { // not found
            return new int[]{};
        }
    }
}

/*
Given an array A of N integers.
Find the largest continuous sequence in a array which sums to zero.

Problem Constraints
1 <= N <= 10^6
-10^7 <= A[i] <= 10^7

Input Format : Single argument which is an integer array A.
Output Format : Return an array denoting the longest continuous sequence with total sum of zero.
NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.

Example Input : A = [1,2,-2,4,-4], output : [2,-2,4,-4]
Explanation [2,-2,4,-4] is the longest sequence with total sum of zero.
 */