package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    public static ArrayList<Integer> arrayToList(int[] arr){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    public static void swapIndicesOfanArray(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static ArrayList<ArrayList<Integer>> TwoDArrayToList(int[][] arr){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                row.add(arr[i][j]);
            }
            result.add(row);
        }
        return result;
    }

    public static <T> void print2DMatrix(ArrayList<ArrayList<T>> arr){
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void print2DMatrix(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void find3SmallestnoInArray(ArrayList<Integer> B){
        int least = Integer.MAX_VALUE, secLeast = Integer.MAX_VALUE, thirdLeast = Integer.MAX_VALUE;
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) <= least) {
                thirdLeast = secLeast;
                secLeast = least;
                least = B.get(i);
            }
            if (B.get(i) <= secLeast  &&  B.get(i) > least){
                thirdLeast = secLeast;
                secLeast = B.get(i);
            }
            if (B.get(i) <= thirdLeast && B.get(i) > secLeast){
                thirdLeast = B.get(i);
            }
        }
        System.out.printf("%d, %d, %d\n", least, secLeast, thirdLeast);
    }

    //public static void print2DMatrix(int[][] arr){
    //    for (int i = 0; i < arr.length; i++) {
    //        System.out.println(Arrays.toString(arr[i]));
    //    }
    //}

    // find factors for a given number
    public static ArrayList<Integer> findFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int incrementer = num % 2 == 0 ? 1 : 2; // Skip two if the number is odd
        for (int i = 1; i <= Math.sqrt(num); i += incrementer) {
            // If there is no remainder, then the number is a factor.
            if (num % i == 0) {
                factors.add(i);
                if (i != num / i) { // Skip duplicates
                    factors.add(num / i);
                }
            }
        }
        return factors;
    }

    public static int getFactorsCount(int num){
        return findFactors(num).size();
    }

    public static boolean checkBit(int num, int i){
        return (((num >> i) & 1) == 1);
    }

    public static int[][] get2dCopy(int[][] mat){
        return Arrays.stream(mat).map(int[]::clone).toArray(int[][]::new);
    }

    // this method will NOT mutate the original matrix
    public static int[][] prefixSumMatrix(int[][] mat){
        int[][] arr = get2dCopy(mat);
        int n = arr.length;
        int m = arr[0].length;
        // adding each columns
        for (int row = 0; row < n; row++) {
            for (int column = 1; column < m; column++) {
                arr[row][column] = arr[row][column-1] + arr[row][column];
            }
        }
        // adding each column
        for (int column = 0; column < m; column++) {
            for (int row = 1; row < n; row++) {
                arr[row][column] = arr[row-1][column] + arr[row][column];
            }
        }
        return arr;
    }

    // this method WILL NOT mutate the original matrix
    public static int[][] prefixSumMatrixMutate(int[][] mat){
        int[][] arr = new int[mat.length][mat[0].length];
        int n = arr.length;
        int m = arr[0].length;
        // adding each columns
        for (int row = 0; row < n; row++) {
            for (int column = 1; column < m; column++) {
                arr[row][column] = arr[row][column-1] + arr[row][column];
            }
        }
        // adding each column
        for (int column = 0; column < m; column++) {
            for (int row = 1; row < n; row++) {
                arr[row][column] = arr[row-1][column] + arr[row][column];
            }
        }
        return arr;
    }

    public static int factorial(int N){
        if (N == 1) return 1;
        return (N * factorial(N-1));
    }

    // following function calculates power in LogN base 2 time
    public static long pow(int a, int n){
        if (n == 0) return 1;
        long he = pow(a, n/2);
        long ha = he * he;
        if ((n % 2) == 0){
            return ha;
        }else{
            return ha * a;
        }
    }
}
