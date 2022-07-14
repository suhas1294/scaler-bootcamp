package _03_advance._2022_07_11.backtracking_1.assignments;

import java.util.ArrayList;

public class Sixlets {
    public int solve(int[] A, int B) {
        return sixlets(A, 0, 0, B);
    }

    public int sixlets(int[] A, int i, int sum, int size) {
        if (sum > 1000) return 0;
        if (size == 0) return 1;
        if (i == A.length) return 0;
        return sixlets(A, i + 1, sum + A[i], size - 1) + sixlets(A, i + 1, sum, size);
    }

    // --------- alternate solution -------------

    public int solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        return subsequences(0, A, temp, B, 0);
    }

    public int subsequences(int i, ArrayList<Integer> A, ArrayList<Integer> temp, int B, int sum) {
        // base condition
        if (i == A.size()) {
            if (sum <= 1000 && temp.size() == B) {
                return 1;
            } else {
                return 0;
            }
        }

        int currEle = A.get(i);

        // add
        sum = sum + currEle;
        temp.add(currEle);
        int x = subsequences(i + 1, A, temp, B, sum);

        // remove
        sum = sum - currEle;
        temp.remove(temp.size() - 1);
        int y = subsequences(i + 1, A, temp, B, sum);

        return x + y;
    }
}

/*
Given a array of integers A of size N and an integer B.
Return number of non-empty subsequences of A of size B having sum <= 1000.

Problem Constraints
1 <= N <= 20
1 <= A[i] <= 1000
1 <= B <= N

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format : Return number of subsequences of A of size B having sum <= 1000.

Input 1: A = [1, 2, 8] B = 2, Output 1: 3
Explanation 1: {1, 2}, {1, 8}, {2, 8}

Input 2: A = [5, 17, 1000, 11] B = 4 Output 2: 0
Explanation 2: No valid subsequence
 */