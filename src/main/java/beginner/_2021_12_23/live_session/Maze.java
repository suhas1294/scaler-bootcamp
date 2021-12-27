package beginner._2021_12_23.live_session;

/**
 * There is a matrix mxn, a rat is present in (1,1) and wants to reach the cell (mxn), in how many ways can
 * the rat travel from (1,1) to (mxn) ? note : we cannot go diagonally
 */

public class Maze {
    public static void main(String[] args) {
        getNoOfWays(3,3); // expected : 6
    }

    // recursive way
    static int getNoOfWays(int x, int y){
        if (x == 1 && y == 1) return 1; //
        if (x < 1 || y < 0) return 0;
        return getNoOfWays(x-1, y) + getNoOfWays(x, y-1);
    }
    // iterative way
    static int getNoOfWaysTo(int[][] arr, int m, int n){
        int sum = 0;
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                sum = arr[m][n-1] + arr[m-1][n];
            }
        }
        return sum;
    }
}
