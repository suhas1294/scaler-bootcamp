package _03_advance._2022_08_17.graphs_5.live_session;

// all pair shortest path i.e., between every 2 node, find shortest path
// note : graph can contain -ve edges but NOT -ve cycles
public class _03_FloydWarshal {
    // brute force soln : apply bellman ford for every node,
    // so TC : Nx(NE) = N²E

    // hence we take approach of 3d DP

    // TC: O(N³), sc: O(N³) which can be optimzed for O(N²)
    // dp state: dp[i, j, k] = min cost to reach from i to j, such that nodes in between can only have nodes between [1,2...k]
    // possibility is either u can pick kth element or leave it.
    // ex : dp[i, j, 3] =  min cost to reach from i to j, nodes in between [1,2,3]

    void floydWarshal(int n){
        // base condition : k = 0 is nothing but adjacency matrix
        //dp state :dp[i, j, 0] = min cost to reach from i to j, in between no nodes
        int[][][] dp = new int[n+1][n+1][2]; // new int[n+1][n+1][n+1] in non-optimized version
        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    dp[i][j][k%2] = Integer.min(
                            dp[i][j][(k-1)%2],
                            dp[i][k][(k-1)%2] + dp[k][j][(k-1)%2]
                    );
                    /*
                    // non space optimized code
                    dp[i][j][k] = Integer.min(
                            dp[i][j][k-1],
                            dp[i][k][k-1] + dp[k][j][k-1]
                    );*/
                }
            }
        }
    }
}
