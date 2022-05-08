package _03_advance._2022_04_04.Combinatorics.live_session;

// property to remember : NcR = (N-1)CR + (N-1)C(R-1)
public class _02_CombinationModPNonPrime {
    // recursive way
    // TC: O(NcR)
    public static int combinationModP(int n, int r, int p) {
        if(n < r) return 0;
        if(r == 0) return 1;
        int a = combinationModP(n-1, r-1, p);
        int b = combinationModP(n-1, r, p);
        return (a + b) % p;
    }

    // iterative way, using dynamic programming.(memoization)
    public static int combinationModP2(int n, int r, int p) {
        // constructing a 2d array for memoization
        int[][] mat = new int[n+1][r+1];
        for (int j = 0; j <= r ; j++) mat[0][j] = 0; //  changing first row values
        for (int i = 0; i <= n; i++) mat[i][0] = 1; //  changing first columns
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= r ; j++) {
                mat[i][j] = (mat[i-1][j] + mat[i-1][j-1]) % p;
            }
        }
        return mat[n][r];
    }

}
/*
Give N, R and p, calculate (Ncr)% p
P is prime.
Constraints:
1 <= (N,R) <= 10^5
R < N < P
p is NOT prime.

 */
