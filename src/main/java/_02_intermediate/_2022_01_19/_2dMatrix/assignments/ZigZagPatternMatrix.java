package _02_intermediate._2022_01_19._2dMatrix.assignments;

import utils.Util;

import java.util.ArrayList;

public class ZigZagPatternMatrix {
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<>();
        boolean reverse = false;
        for (int i = 1; i <= (A * A); i+=A) {
            ArrayList<Integer> row = new ArrayList<>();
            reverse = ((i-1 != 0) && (i-1) % A == 0 && !reverse);
            // understandable code
            /*if ((i-1) % A == 0 && !reverse && (i-1 != 0)){
                reverse = true;
            }else if((i-1) % A == 0 && reverse){
                reverse = false;
            }*/
            for (int j = i; j <= i+(A-1); j++) {
                if(reverse){
                    row.add(0, j);
                }else{
                    row.add(j);
                }
            }
            spiralMatrix.add(row);
        }
        return spiralMatrix;
    }

    public static void main(String[] args) {
        Util.print2DMatrix(generateMatrix(80));
    }

}

/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
1 <= A <= 1000
input format : First and only argument is integer A
output format: Return a 2-D matrix which consists of the elements in spiral order.

Input 1: 1, output : [ [1] ], explanation: Only 1 is to be arranged.

Input 2: 2, output : [ [1, 2], [4, 3] ]
explanation:
1 --> 2
      |
      |
4<--- 3

 */