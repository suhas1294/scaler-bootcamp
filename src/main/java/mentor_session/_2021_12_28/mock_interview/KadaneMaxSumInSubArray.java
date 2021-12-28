package mentor_session._2021_12_28.mock_interview;

public class KadaneMaxSumInSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, -1, -2, 4, 5, 9, -10};
        System.out.println(maxSubArraySum2(arr));
    }
    static int maxSubArraySum2(int[] arr){
        int maxSum = arr[0];
        int curSum = arr[0];
        for (int i = 1; i < arr.length; i++){
            curSum = Math.max(arr[i], curSum+arr[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
