package _03_advance._2022_07_18.dynamic_programming_1.live_session;

// write code to get nth fibonacci number
public class _02_FibonacciVariations {
    // regular fibonacci code using recursion (without dynamic programming)
    int fib1(int n){
        if (n <= 1) return n;
        return fib1(n-1) + fib1(n-2);
    }

    // using dynamic programming - recursive + memoization + top-down approach
    int[] dp;
    int fib2(int n){
        dp = new int[n+1];
        if (n <= 1) return n; // optional : if (n <= 1) {dp[n] = n; return n;}
        if (dp[n] == -1){ // fib(n) is called for first time
            dp[n] = fib2(n-1) + fib2(n-2);
            return dp[n]; // actually not required
        }
        return dp[n];
    }

    // using dynamic programming - iterative + tabulation + bottom up approach
    // tc : o(n), sc : O(n)
    int fib3(int n){
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // using dynamic programming - iterative + tabulation + bottom up approach + space optimization
    // tc : o(n), sc : O(1)
    int fib4(int n){
        int a = 0, b = 1;
        int c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

}
