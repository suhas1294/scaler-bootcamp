package _03_advance._2022_05_04.hashing_2.live_session;

public class _01_CheckIfTriangleCanBeFormed {
    //public static void countTriangles(int[][] xy){ // this can be another format for parameters
    // TC: O(1) and sc: O(1)
    public static boolean canItBeATriangles(int[] x, int[] y){
        int x1 = x[0], x2 = x[1], x3 = x[2];
        int y1 = y[0], y2 = y[1], y3 = y[2];

        boolean c1 = (y1 == y2 && x1 == x3) ||  (y1 == y3 && x1 == x2);
        boolean c2 = (y2 == y1 && x2 == x3) ||  (y2 == y3 && x1 == x2);
        boolean c3 = (y1 == y3 && x2 == x3) ||  (y3 == y2 && x3 == x1);

        return c1 || c2 || c3; // true = triangle can be formed.
    }
}
/*

Given 3 distinct points in a 2d plane, check if there is form triangle such that
shorter sides are parallel to x axis and y axis respectively
ex-1 : (1,8), (1,4), (5,4)
ex-2 : (5,10), (1,3), (5,3)
ex-3 : (4,3), (8,3), (4,8)

Prerequsite information:
1. Only in a right angle triangle, two sides will be parallel to x and y axis.
2. if two points say (x1, y1) and (x2, y2) is parallel to
    x-axis then, y1 = y2
    y-axis then, x1 = x2

soln : take every point as center (which forms 90 deg in right angle triangle) and check other two sides
are parallel to x and y axis. refer notes for detialed explanation.


 */