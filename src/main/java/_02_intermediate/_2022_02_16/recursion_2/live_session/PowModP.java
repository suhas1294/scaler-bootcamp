package _02_intermediate._2022_02_16.recursion_2.live_session;

// calculate (a^n)%p
public class PowModP {
    static long powModP(int a, int n, int p){
        if (n == 0) return 1;
        long he = powModP(a, n/2, p);
        long ha = ((he % p) * (he % p) % p);
        if (n % 2 == 0){
            return ha;
        }else{
            return ((ha % p) * (a % p) % p);
        }
    }

    // constraint : -10^9 < A < 10^9
    // Note : In Java, negative num % p will not give expected result, add p if mod result is -ve
    // power function
    static int pow(int A, int B, int C){
        if (B == 0) return 1 % C;
        long he = pow(A, B/2, C);
        long ha = ((he % C) * (he % C) % C);
        if (B % 2 == 0){
            if (ha < 0){
                return (int)(ha + C);
            }
            return (int)ha;
        }else{
            long res = ((ha % C) * (A % C) % C);
            if (res < 0) return (int)(res + C);
            return (int)res;
        }
    }

    public static void main(String[] args) {
        //System.out.println(pow(0, 0 ,1 )); // 0
        System.out.println(pow(-1, 1, 20 )); // 19
    }

}

// constraints : 1 < (a,n,p) <= 10^9
