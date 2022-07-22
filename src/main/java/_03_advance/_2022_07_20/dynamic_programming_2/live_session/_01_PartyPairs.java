package _03_advance._2022_07_20.dynamic_programming_2.live_session;

public class _01_PartyPairs {
    // tc : O(n) , sc : O(n)
    // note : at any given point of time we are using only 3 states, so we can reduce SC: O(1)
    int partyPair(int n){
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + ((i-1) * dp[i-2]);
        }
        return dp[n];
    }

    int partyPairSpaceEffecient(int n){
        int a = 1, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + ((i-1) * b);
            a = b;
            b = c;
        }
        return c;
    }
}

/*
given n pairs, how many ways we can pair all people.
note : a person either wants to stay alone or get paired. All people need to attend party.
dp state : dp[i] : number of ways to party i number of people
dp expression : dp[i] = dp[i-1] +(i-1)dp[i-2]
base condition: above expression for i = 0 and i = 1
 */