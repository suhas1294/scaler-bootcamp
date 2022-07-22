package _03_advance._2022_07_18.dynamic_programming_1.live_session;

public class _01_DpIntro {
    /*

        Dynamic programming :
        optimal substructure - that is , when problem can be broken down into sub problems.
        over lapping sub problems - when the sub problems are repeating.

        Recursion with extra memory = memoization approach.
        Iterative  + extra memory = tabulation

        Top-down approach : In recursive tree, we are going from top to bottom and then coming back.
        bottom-up approach : In recursive tree, we are starting from bottom and reaching top

        Bottom-up (Tabulation)
          - Its implemented with iteration and start with base cases.

        Top-down (Memoization)
          - Its implemented with recursion and made efficient with memoization.
        ref :  https://leetcode.com/explore/featured/card/dynamic-programming/630/an-introduction-to-dynamic-programming/4035/


        DP steps :
        1. identify if problem falls into optimal substructure
        2. check if there is overlapping sub problem pattern
        3. Identify following steps :
            1. DP state - what should it contain ?
            2. dp expression - how to calculate dp state. ex: dp[i]
            3. base condition - for which input values, Dp expression will fail
            4. dp table - to store dp values
            5. code and return ans
            6. tc : (# of dp states * TC for each state), sc : (dp table size)
            7. optimize :
                1. tc : depends on problem
                2. sc : in general, only possible in iterative approach, based on no of dp states, we can optimize.

     */
}
