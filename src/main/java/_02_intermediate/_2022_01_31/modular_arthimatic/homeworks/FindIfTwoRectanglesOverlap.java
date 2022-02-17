package _02_intermediate._2022_01_31.modular_arthimatic.homeworks;

public class FindIfTwoRectanglesOverlap {
    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        // If one rectangle is on left side of other
        if (A >= G || E >= C)
            return 0;

        // If one rectangle is above other
        if (B >= H || F >= D)
            return 0;

        return 1;
    }

    public static void main(String[] args) {
        //System.out.println(solve(6, 3, 9, 4, 2, 6, 5, 10));
        System.out.println(solve(6,8,10,9,6,1,9,6));
    }
}

/*
Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.
For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the
second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).
Find and return whether the two rectangles overlap or not.

-10000 <= A < C <= 10000
-10000 <= B < D <= 10000
-10000 <= E < G <= 10000
-10000 <= F < H <= 10000

input format: The eight arguments given are the integers A, B, C, D, E, F, G and H.
output format: Return 1 if the two rectangles overlap else return 0.

Input 1:
A = 0   B = 0
C = 4   D = 4
E = 2   F = 2
G = 6   H = 6

output : 1
exp: rectangle with bottom left (2,2) and top right (4,4) is overlapping.

Input 2:
A = 0   B = 0
C = 4   D = 4
E = 2   F = 2
G = 3   H = 3

output : 1
exp: overlapping rectangles can be found

credits: https://github.com/black-shadows/InterviewBit-Topicwise-Solutions/blob/master/Math/Find%20if%20two%20rectangles%20overlap.cpp
 */