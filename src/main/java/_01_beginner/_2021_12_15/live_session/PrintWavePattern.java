package _01_beginner._2021_12_15.live_session;

public class PrintWavePattern {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        // expected output : 1, 5, 9, 10, 6, 2, 3, 7, 11, 12, 8, 4

        for (int column = 0; column < arr[0].length; column++) { // i = columns
            if (column % 2 == 0){ // top to bottom
                for (int row = 0; row < arr.length; row++) {
                    System.out.print(arr[row][column] + "\t");
                }
            }else{ // bottom to top
                for (int row = arr.length-1; row >= 0; row--) {
                    System.out.print(arr[row][column] + "\t");
                }
            }
        }
    }
}
