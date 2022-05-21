package _03_advance._2022_04_25.binary_search_3.assignments;

// similar to (src/main/java/_03_advance/_2022_04_25/binary_search_3/live_session/MinTimeToCompleteTasks.java)
public class PainterPartitionProblem {
    // A : number of painters,
    // B : time taken by 1 painter to paint 1 unit of board
    // C : list of boards
    public static int paint(int A, int B, int[] C) {
        long max = Integer.MIN_VALUE;
        long sum = 0, ans = 0;
        // max = largest board in (list of boards)
        // sum = sum of total boards (board units)
        for (int i = 0; i < C.length; i++) {
            max = Math.max(max, C[i]);
            sum += C[i];
        }
        // left = if there were one painter per board, then what would be max
        // time taken to complete painting all boards
        long left = max * B;

        // right = if there was only 1 painter for all boards, then time taken by him to paint
        // all boards = sum * B
        long right = sum * B;

        while (left <= right) {
            long mid = left + ((right - left) / 2);
            // check if painters can paint all boards in mid time.
            if (checkPaintersCanPaintAllBoardsUnderMidTime(A, B, C, mid)) {
                // say if 3 painter can paint all boards in 'mid' time - say 5 min,
                // then they can surely complete in 6,7,8 etc min. So search for better ans,
                // move to left
                ans = mid;
                right = mid - 1;
            } else {
                // say if 3 painter can not paint all boards in 'mid' time - say 5 min,
                // then they definitely can not complete in 4,3,2... etc min. So we need more time
                // move to right
                left = mid + 1;
            }
        }
        return (int) (ans % 10000003);
    }

    public static boolean checkPaintersCanPaintAllBoardsUnderMidTime(long A, long B, int[] C, long mid) {
        long painter = 1;
        long totalTime = 0;
        for (int i = 0; i < C.length; i++) {
            if (totalTime + (long) C[i] * B > mid) {
                painter++;
                totalTime = (long) C[i] * B;
            } else {
                totalTime += (long) C[i] * B;
            }
        }
        if (painter <= A) {
            return true;
        }
        return false;
    }
}

/*
Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the
length of ith board. You have to paint all N boards [C0, C1, C2, C3 … CN-1].
There are A painters available and each of them takes B units of time to paint 1 unit of the board.
Calculate and return the minimum time required to paint all boards under the constraints
that any painter will only paint contiguous sections of the board.

NOTE:
1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.

Return the ans % 10000003.

Problem Constraints
1 <= A <= 1000
1 <= B <= 10^6
1 <= N <= 10^5
1 <= C[i] <= 10^6

Input Format
The first argument given is the integer A.
The second argument given is the integer B.
The third argument given is the integer array C.

Output Format
Return minimum time required to paint all boards under the constraints that any painter will
only paint contiguous sections of board % 10000003.

Input 1: A = 2 B = 5 C = [1, 10] Output 1: 50
Explanation 1:
 Possibility 1:- One painter paints both blocks, time taken = 55 units.
 Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 There are no other distinct ways to paint boards.
 ans = 50 % 10000003

Input 2: A = 10 B = 1 C = [1, 8, 11, 3] Output 2: 11
Explanation 2:
 Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 ans = 11 % 10000003
 */