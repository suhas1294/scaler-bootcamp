package _02_intermediate._2022_01_19._2dMatrix.assignments;

import utils.Util;

import java.util.ArrayList;

public class PrintSpiralMatrix {
    public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> normalMatrix = new ArrayList<>();
        if (A == 1) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            normalMatrix.add(arr);
            return normalMatrix;
        }

        for (int i = 1; i <= (A * A); i+=A) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = i; j <= i+(A-1); j++) {
                row.add(j);
            }
            normalMatrix.add(row);
        }

        // print it normal matrix in spiral way
        ArrayList<ArrayList<Integer>> spiralMatrix = new ArrayList<>();
        int direction = 0, top = 0, bottom = A-1 , left = 0, right = A-1;

        while (top <= bottom && left <= right ){
            ArrayList<Integer> row = new ArrayList<>();
            switch (direction){
                case 0:
                    for (int i = left; i <= right; i++) {
                        row.add(normalMatrix.get(top).get(i));
                    }
                    top++;
                    break;
                case 1:
                    for (int i = top; i <= bottom ; i++) {
                        row.add(normalMatrix.get(i).get(right));
                    }
                    right--;
                    break;
                case 2:
                    for (int i = right; i >= left ; i--) {
                        row.add(normalMatrix.get(bottom).get(i));
                    }
                    bottom--;
                    break;
                default: // 3
                    for (int i = bottom; i >= top ; i--) {
                        row.add(normalMatrix.get(i).get(left));
                    }
                    left++;
            }
            spiralMatrix.add(row);
            direction = (direction + 1) % A;
        }
        return spiralMatrix;
    }

    public static void main(String[] args) {
        Util.print2DMatrix(generateMatrix(5));
    }
}