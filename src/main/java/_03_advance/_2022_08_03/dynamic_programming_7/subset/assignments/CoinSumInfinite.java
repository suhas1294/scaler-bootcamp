package _03_advance._2022_08_03.dynamic_programming_7.subset.assignments;

import java.util.Arrays;

public class CoinSumInfinite {
    // iterative approach
    public int coinchange2(int[] a, int k) {

        int n = a.length;
        int[] first = new int[k+1];
        int[] second = new int[k+1];

        for(int i=0; i<n; i++)
        {
            second[0] = 1;
            for(int j=1; j<=k; j++)
            {
                second[j] = ( first[j] + (j-a[i] >= 0 ? second[j-a[i]] : 0) )%1000007;
            }
            int[] temp = first;
            first = second;
            second = temp;
        }

        return first[k];
    }

    // ---------------- recursive approach ------------------
    public int coinchange3(int[] A, int B) {
        int m = A.length;
        int[][] dp = new int[m+1][B+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return coinChange(m,B,A,dp);
    }

    public int coinChange(int i, int j, int[] A, int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i == 0) return 0;
        if(j == 0) return 1;

        if(dp[i][j] != -1)
            return dp[i][j];
        if(j >= A[i-1])
            dp[i][j] = coinChange(i-1,j,A,dp)%1000007 + coinChange(i,j-A[i-1],A,dp)%1000007;
        else
            dp[i][j] = coinChange(i-1,j,A,dp)%1000007;

        return dp[i][j]%1000007;
    }

    // ---------------- space optimized solution ------------------
    public int coinchange4(int[] A, int B) {
        int modulo = 1000007;

        int len = A.length;
        int[][] ways = new int[2][B+1];
        ways[0][0]=1;

        for(int r=1; r<B+1; r++){
            if(r-A[0] < 0)
                ways[0][r]=0;
            else
                ways[0][r]=ways[0][r-A[0]];
        }

        int[] firstArr = ways[0];
        int[] secondArr = ways[1];

        for(int i=1; i<len; i++){
            for(int r=0; r<B+1; r++){
                secondArr[r] = ((A[i]<=r?secondArr[r-A[i]]:0) + firstArr[r])%modulo;
            }

            int[] tempArr = firstArr;
            firstArr = secondArr;
            secondArr = firstArr;
        }
        return firstArr[B];
    }

}

/*
You are given a set of coins A. In how many ways can you make sum B assuming
you have infinite amount of each coin in the set.
NOTE:
Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).

Problem Constraints
1 <= A <= 500
1 <= A[i] <= 1000
1 <= B <= 50000

Input Format
First argument is an integer array A representing the set.
Second argument is an integer B.

Output Format : Return an integer denoting the number of ways.

Input 1: A = [1, 2, 3] B = 4, Output 1: 4
Explanation 1:
 The 4 possible ways are:
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}

Input 2: A = [10] B = 10, Output 2: 1
Explanation 2:

 There is only 1 way to make sum 10.
 */
