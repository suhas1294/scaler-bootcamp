package _03_advance._2022_03_30.GCD.live_session;

public class _03_GetMaxGCDByDeletingOneElement {
    public static int getMaxGCD(int[] A){
        int n = A.length;
        // step-1 : construct prefix gcd array
        int[] pf_gcd = new int[n];
        pf_gcd[0] = A[0];
        for (int i = 1; i < n; i++) {
            pf_gcd[i] = _01_EuclideanGCD.getGCD(A[i], pf_gcd[i-1]);
        }
        // step-2 : construct suffic gcd array
        int[] sf_gcd = new int[n];
        sf_gcd[A.length-1] = A[n-1];
        for (int i = n-2; i >= 0 ; i--) {
            sf_gcd[i] = _01_EuclideanGCD.getGCD(A[i], sf_gcd[i+1]);
        }
        // step-3 : loop through array and get the gcd of whole array except ith element
        int ans = sf_gcd[1];
        for (int i = 1; i < n; i++) {
            int left = pf_gcd[i-1];
            int right = i==n-1 ? Math.max(ans, pf_gcd[n-2]) : sf_gcd[i+1]; // (i == n-1) is a edge case
            ans = Integer.max(ans, _01_EuclideanGCD.getGCD(left, right));
        }
        return ans;
    }
}

/*
Given n array elements, we have to delete one element, such that GCD of remaining element is max.
ex: intput : [24, 16, 18, 30, 15], output : 3
 */

