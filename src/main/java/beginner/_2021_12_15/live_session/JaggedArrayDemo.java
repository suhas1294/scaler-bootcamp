package beginner._2021_12_15.live_session;

import java.util.Scanner;

public class JaggedArrayDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfRows = scanner.nextInt();
        int[][] ja = new int[noOfRows][];

        for (int i = 0; i < ja.length; i++) {
            System.out.println("create an array, how many column you need ?");
            int cols = scanner.nextInt();
            ja[i] = new int[cols]; // was missing initially, if not present will get "Cannot store to int array because 'ja[i]' is null" error
            for (int j = 0; j < cols; j++) {
                ja[i][j] = scanner.nextInt();
            }
        }

        print2dArray(ja);
    }

    static void print2dArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
