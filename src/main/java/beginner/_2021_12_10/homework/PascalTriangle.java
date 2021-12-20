package beginner._2021_12_10.homework;

import java.util.ArrayList;
import java.util.HashMap;

/*
Write a program to input an integer N from user and print pascal triangle up to N rows.
1 <= N <= 25
input: First line is an integer N.
output: N lines whose each row contains N+1 space separated integers.
Ex:
input : 3
output:
1 0 0
1 1 0
1 2 1

explanation: (combinations)
Row 1 = 1 0 0 0 0
Row 2 = 1C0 1C1 0 0 0= 1 1 0 0 0
Row 3 = 2C0 2C1 2C2 0 0= 1 2 1 0 0
Row 4 = 3C0 3C1 3C2 3C3 0= 1 3 3 1 0

input : 5
output:
1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1
 */

public class PascalTriangle {
    static HashMap<Integer, Integer> factTable = new HashMap<>();
    public static void main(String[] args) {
        //solve(25);
        /*ArrayList<ArrayList<Integer>> result = solve(25);
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }*/
        solve2(25);
    }

    // optimized approach - no need to calculate any factorial
    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= A+1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);

            // pascal numbers
            for (int j = 1; j < i-1; j++) {
                ArrayList<Integer> prevRow = result.get(i-2);
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            // adding leading zeros
            for (int j = 0; j <= A-i; j++) {
                if (i != 1)row.add(0);
            }

            result.add(row);
        }
        result.remove(0);
        return result;
    }

    public static void solve2(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= A+1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);

            // pascal numbers
            for (int j = 1; j < i-1; j++) {
                ArrayList<Integer> prevRow = result.get(i-2);
                int prevRowLeft = prevRow.get(j-1);
                int prevRowRight = 0;
                try {
                    prevRowRight = prevRow.get(j);
                }catch (Exception e){}
                row.add(prevRowLeft + prevRowRight);
            }
            result.add(row);
        }

        result.remove(0);
        for (ArrayList<Integer> row : result) {
            for (Integer no : row) {
                System.out.print(no + " ");
            }
            System.out.println();
        }
    }

    // not-optimised method which may work until 13!

    /*public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> rowResult = new ArrayList<>();
            // print values
            for (int j = 0; j <= i; j++) {
                System.out.print(combination(i, j) + "\t");
                rowResult.add(combination(i, j));
            }
            // print zeros
            for (int j = 0; j < A - i - 1; j++) {
                System.out.print(0 + "\t");
                rowResult.add(0);
            }
            result.add(rowResult);
            System.out.println();
        }
        return result;
    }

    private static int combination(int n, int r){
        if (r == 0) return 1;
        if (r == 1) return n;
        int rCompliment = r;
        if (n - r < r){
            rCompliment = n - r;
        }
        int result = factorial(n) / (factorial(rCompliment) * factorial((n - rCompliment)));
        return result;
    }

    private static int factorial(int N){
        if (N == 1 || N == 0) return 1;
        if (factTable.get(N) != null) return factTable.get(N);
        int result =  (N * factorial(N-1));
        factTable.put(N, result);
        return result;
    }*/
}


// expected answer for A = 25 :
/*
[1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 3 3 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 4 6 4 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 5 10 10 5 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 6 15 20 15 6 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 7 21 35 35 21 7 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 8 28 56 70 56 28 8 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 9 36 84 126 126 84 36 9 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 10 45 120 210 252 210 120 45 10 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 11 55 165 330 462 462 330 165 55 11 1 0 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 12 66 220 495 792 924 792 495 220 66 12 1 0 0 0 0 0 0 0 0 0 0 0 0 ]
[1 13 78 286 715 1287 1716 1716 1287 715 286 78 13 1 0 0 0 0 0 0 0 0 0 0 0 ]
[1 14 91 364 1001 2002 3003 3432 3003 2002 1001 364 91 14 1 0 0 0 0 0 0 0 0 0 0 ]
[1 15 105 455 1365 3003 5005 6435 6435 5005 3003 1365 455 105 15 1 0 0 0 0 0 0 0 0 0 ]
[1 16 120 560 1820 4368 8008 11440 12870 11440 8008 4368 1820 560 120 16 1 0 0 0 0 0 0 0 0 ]
[1 17 136 680 2380 6188 12376 19448 24310 24310 19448 12376 6188 2380 680 136 17 1 0 0 0 0 0 0 0 ]
[1 18 153 816 3060 8568 18564 31824 43758 48620 43758 31824 18564 8568 3060 816 153 18 1 0 0 0 0 0 0 ]
[1 19 171 969 3876 11628 27132 50388 75582 92378 92378 75582 50388 27132 11628 3876 969 171 19 1 0 0 0 0 0 ]
[1 20 190 1140 4845 15504 38760 77520 125970 167960 184756 167960 125970 77520 38760 15504 4845 1140 190 20 1 0 0 0 0 ]
[1 21 210 1330 5985 20349 54264 116280 203490 293930 352716 352716 293930 203490 116280 54264 20349 5985 1330 210 21 1 0 0 0 ]
[1 22 231 1540 7315 26334 74613 170544 319770 497420 646646 705432 646646 497420 319770 170544 74613 26334 7315 1540 231 22 1 0 0 ]
[1 23 253 1771 8855 33649 100947 245157 490314 817190 1144066 1352078 1352078 1144066 817190 490314 245157 100947 33649 8855 1771 253 23 1 0 ]
[1 24 276 2024 10626 42504 134596 346104 735471 1307504 1961256 2496144 2704156 2496144 1961256 1307504 735471 346104 134596 42504 10626 2024 276 24 1 ] */
