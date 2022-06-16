package _03_advance._2022_04_22.binary_search_2.live_session;

// find floor(square root of number) using binary search
public class SqrtBinarySearch {
    public static int sqrt(int n){
        int l = 1, h = n, ans = 0;
        while (l <= h){
            int m = (l+h)/2;
            if (m * m == n) return m;
            if (m * m < n){ // m is potential answer, go to right for better answer
                ans = m;
                l = m+1;
            }else{
                h = m-1;
            }
        }
        return ans;
    }

    // edge cases are covered here.
    public static int sqrt2(int n) {
        long low = 1, high = n;
        long ans = 0;
        while (low <= high) {
            long mid = low + ((high - low) / 2);
            if (mid * mid == n) {
                return (int) mid;
            } else if (mid * mid < n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) (ans%1000000007);
    }
}
