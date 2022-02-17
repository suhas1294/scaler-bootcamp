package _02_intermediate._2022_01_31.modular_arthimatic.live_session;
import static _02_intermediate._2022_01_31.modular_arthimatic.live_session._01_PowerModulus.power;

public class _02_HugeNumModP {
    // efficient code
    public static long largeNoModulus(int[] arr, int p){
        long ans = 0;
        long exp = 1;
        for (int i = arr.length-1; i >= 0 ; i--) {
            ans = ans + ((arr[i] * exp) % p);
            ans = ans % p;
            exp = (exp * 10) %p;
        }
        return ans;
    }

    public static int largeNoModulus(String A, int B){
        String[] arr = A.split("");
        long ans = 0;
        long exp = 1;
        for (int i = arr.length-1; i >= 0 ; i--) {
            ans = ans + ((Integer.parseInt(arr[i]) * exp) % B);
            ans = ans % B;
            exp = (exp * 10) % B;
        }
        return (int)ans;
    }

    public static int largeNoModulus2(int[] arr, int p){
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans  + (
                    ( (arr[i] % p) * (power(10, n-i-1, p)) ) % p
            );
            ans = ans % p;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largeNoModulus( new int[]{3, 2, 4, 6, 4}, 4)); // 0
        System.out.println(largeNoModulus( new int[]{2,3,7,4,6,9,7,4,5,3,7,9,4,5,9,3}, 7)); // 4
    }
}

/*
Given a very huge number in array format, calculate (Num % p)
 */