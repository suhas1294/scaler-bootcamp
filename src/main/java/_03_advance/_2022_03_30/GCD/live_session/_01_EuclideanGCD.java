package _03_advance._2022_03_30.GCD.live_session;

public class _01_EuclideanGCD {
    public static int getGCD(int a, int b){
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static int getGcdOfArray(int[] arr){
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = getGCD(ans, arr[i]);
        }
        return ans;
    }
}
