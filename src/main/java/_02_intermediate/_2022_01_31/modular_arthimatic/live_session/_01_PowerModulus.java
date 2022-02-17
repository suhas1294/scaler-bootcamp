package _02_intermediate._2022_01_31.modular_arthimatic.live_session;

public class _01_PowerModulus {
    public static int power(int a, int n, int p){
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            //ans = ((ans * a) % p); // overflow happens
            ans = ( ((ans % p) * (a % p)) % p );
        }
        return ans;
    }

}

/*
given a, n, and p calculate (a^n)%p

 */