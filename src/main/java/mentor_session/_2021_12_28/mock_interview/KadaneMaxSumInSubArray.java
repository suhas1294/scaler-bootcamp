package mentor_session._2021_12_28.mock_interview;

public class KadaneMaxSumInSubArray {

    // approach-1 : bruteforce : n^3,
    // approach-2 : use prefix sum, n^2, sc: o(n)
    // approach-3 : with carry forward, n^2, sc: o(1)
    // approach-1 : kadane algorithm : o(n), sc: o(1)

    // source : from advance class, refer notes
    // src/main/java/_03_advance/_2022_03_14/arrays/live_session/_07_max_sub_array_sum.txt
    public static int maxSubArraySum(int[] arr){
        int sum = 0;
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            ans = Integer.max(ans, sum);
            if (sum < 0){  // reset sum if its negative.
                sum = 0;
            }
        }
        return ans;
    }

    // source : from GFG
    static int maxSubArraySum2(int[] arr){
        int maxSum = arr[0];
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++){
            curSum = Math.max(arr[i], curSum+arr[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, -1, -2, 4, 5, 9, -10};
        System.out.println(maxSubArraySum2(arr));
    }
}
