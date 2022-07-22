package _03_advance._2022_07_18.dynamic_programming_1.live_session;

public class _04_Cowry2FacedDice {
    // dp state : dp[i] = # of ways to get sum i
    // dp expression : dp[i] = dp[i-1] + dp[i-2]
    // rest its same as N stair problem
}

/*
There is a two faced dice, we can roll dice as many times as we want
what is no of ways to get sum N ?
ex:
n = 1, ways = 1; {1}
n = 2, ways = 2 {1,1} {2}
n = 3, ways = 3 {1,1,1} {1,2} {2,1}
n = 4, ways = 5, {1,1,1,1,1} {1,1,2} {1,2,1} {2,1,1} {2,2}
 */