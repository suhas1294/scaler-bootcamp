package _02_intermediate._2022_02_16.recursion_2.live_session;

// calculate a^n
public class CalculatePowerRecursion {

    // efficient approach , TCL LogN base 2
    static long pow(int a, int n){
        if (n == 0) return 1;
        long he = pow(a, n/2);
        long ha = he * he;
        if ((n % 2) == 0){
            return ha;
        }else{
            return ha * a;
        }
    }

    // inefficient approach
    static long pow2(int a, int n){
        if (n == 0) return 1;
        if (n == 1) return a;
        return a * pow2(a, n-1);
    }
}
