package _02_intermediate._2022_02_02.adhoc.live_session;

public class FindLastAlivePerson {
    public static int getAlivePerson(int n){
        int p = getNearestPowerOf2LTN(n);
        return (2 * (n-p)) + 1;
    }

    // helper func: get nearest power of 2 less then n
    static int getNearestPowerOf2LTN(int n){
        int i = 1;
        while((i * 2) < n){
            i = i * 2;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getNearestPowerOf2LTN(100));
    }
}

/*
Initially there are n persons in a circle, person-1 has knife, he kills his adjacent clockwise person,
and pass the knife to next adjacent clockwise person. repeat until only single person stands, who is
that single person ?
ex:
n = 7, ans = 7
n = 6, ans = 5
n = 4, ans = 1

When n is a perfect square, then whoever starts the game, will be last person alive.

soln steps:
get nearest power of 2 which is less then n - say x
ex: n = 100, nearest power of 2 < 100  = 64
So, number of kills that is made so far = 100 - 64 = 36
therefore total number of jumps taken is (2 x 36) + 1 (initial position) = 73
so 73rd person will be alive.
 */
