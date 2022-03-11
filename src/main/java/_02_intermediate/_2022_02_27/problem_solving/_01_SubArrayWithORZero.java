package _02_intermediate._2022_02_27.problem_solving;

public class _01_SubArrayWithORZero {
    // arr is binary array
    public static long subArrayWithOrZero(int[] arr){
        int n = arr.length;
        long ans = 0, cntOf0 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0){
                cntOf0++;
            }else{
                ans = ans + (((long) n * (n+1))/2);
                cntOf0 = 0;
            }
        }
        ans = ans + ((cntOf0 * (cntOf0 +1))/2);
        return ans;
        /*int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            if (arr[i] == 0){
                while(i < arr.length && arr[i] == 0){
                    i++;
                    cnt++;
                }
                sum += ((cnt * (cnt+1))/2);
            }
        }
        return sum;*/
    }

    public static void main(String[] args) {
        System.out.println(subArrayWithOrZero(new int[]{1,1,0,0,0,1,0,1,0,0}));
        System.out.println(subArrayWithOrZero(new int[]{0,0,1,0,0,0})); // edge case
    }
}
/*
Given a binary array, calculate, number of subarrays, whose OR is zero
(after applying on all elements of that subarray, result should be 0).

soln: even if there is one single 1 in subarray, OR cannot be zero, So
indirectly you need to give all subarrays which has only 0 in it.

Number of subarrays for a given array = (n * (n+1))/2
therefore, number of subarrays with OR zero  =
ex: 1 1 0 0 0 1 0 1 0 0

0 0 0   (3 continious elements)
0       (1 continious elements)
0 0     (2 continious elements)

(3*(3+1))/2 +
(1*(1+1))/2 +
(2*(2+1))/2

= 10,

therefore, ans = 10.

 */
