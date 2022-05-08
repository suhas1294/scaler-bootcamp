package _03_advance._2022_03_28.modular_arithmatic.live_session;

public class _03_FindInverseModulo {
    // brute force method, TC: O(m) and sc : O(1)
    public static int getInverseModExists(int a, int m){
        for (int i = 0; i < m; i++) {
            if ((a * i) % m == 1) return i;
        }
        return -1;
    }
    // To lessen the time complexity, there is one more trickier algo:
    // Extended Euclidean which takes o(log m)

    // one more o(log m) solution BUT it applies ONLY if m is prime.
    // name of algo is : Fermat's little theorem
    // we know that b  = a^-1 % m
    // we get inverse modulo with this: (a^m-2) % m
    // and a^m-2 can be calculated using :
    // _02_intermediate._2022_01_31.modular_arthimatic.live_session._01_PowerModulus

}

/*
 (a/b) % m = (a * b^-1) % m = ( (a % m) * (b^-1 % m) ) % m
 Given a, m, Inverse mod exists if and only if GCD of (a, m) = 1
 i.e., inverse modulo b exists and its value follows like this:
 b = ((a^-1) % m), m will range from (1 to m-1) and not (0 to m-1) as in normal case
 example, take a = 7, m = 10, b exists.
 Practical application of inverse modulo : Heavily used in cryptography, (ex: RSA)
 */