package _03_advance._2022_04_22.binary_search_2.live_session;

// TC: n log n, sc : o(1)
public class MaxSubArraySumOfKLessThenB {
    public static int solve(int[] a, int b){
        int n = a.length;
        int l = 0, h = n; // not n-1, because try ex: {3,2,5}, b = 3, ans = 3
        int ans = 0;
        while ( l <= h){
            int m = (l+h)/2;
            int sum = maxSubArraySumOfLengthK(a, m);
            if (sum <= b){
                ans = m; // potential answer
                l = m+1; // move right for better answer
            }else{ // move left
                h = m-1;
            }
        }
        return ans;
    }

    // #IMPORTANT, sliding window technique
    // TC: log n
    public static int maxSubArraySumOfLengthK(int[] a, int k){
        if(k == 0 || a.length == 0) {
            return 0;
        }

        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            windowSum += a[windowEnd]; // Add the next element to the window

            if(windowEnd-windowStart+1 == k) { // When we hit the window size. Update maximum sum, and slide the window
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= a[windowStart]; // Subtract the element going out of the window
                windowStart++; // Slide the window
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,3,4,5}, 10));
        System.out.println(solve(new int[]{5,17,100,11}, 130));
    }
}

/*
given an array of length n consisting of positive integers, find the max k such that
(max subarray sum of length k <= B) where B is given in question.
ex: arr[8] = {3,2,5,4,63,7,2}
k , max sum of subarray of length k, ans
1       7   ( <= 20)                , 1 (potential ans)
2       10  ( <= 20)                , 2 (potential ans)
3       16  ( <= 20)                , 3 (potential ans)
4       20  ( <= 20)                , 4 (potential ans)
5       25  ( > 20)                , break

return 4
 */