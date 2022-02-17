package _02_intermediate._2022_02_02.adhoc.live_session;

public class PerfectSquaresUntilN {
    public static int countPerfectSquareUntilN(int n){
        return (int)Math.floor(Math.sqrt(n));
    }
}
/*
Given a number n, count how many perfect squares are there until n
ex:
n = 25, ans : 5, because, until and including 25 - 1,2,4,9,16,25
n = 50, ans : 7, because, until and including 25 - 1,2,4,9,16,25,36,49

 */
