package _02_intermediate._2022_01_28.bit_manipulation.live_session;

public class _04_MaxConsequtiveOnes_Replace {
    public static int maxConsequtiveOnes(int[] arr){
        // step-1 : calculate total number of 1s
        int totalOnes = 0;
        for (int i = 0; i < arr.length; i++) { if(arr[i] == 1) totalOnes++;}
        if (totalOnes == arr.length) return totalOnes;

        // step-2 :
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                int left = 0, right = 0;
                // calculate number of continious ones towards left
                for (int j = i-1; j >= 0; j--) {
                    if(arr[j] == 1){
                        left++;
                    }else {
                        break;
                    }
                }
                // calculate number of continious ones towards right
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j] == 1){
                        right++;
                    }else {
                        break;
                    }
                }
                ans = Math.max(ans, (left + right + 1) );
            }
        }
        return ans;
    }
}

/*
Given a binary arr[], we can atmost replace a single 0 with 1, find max consequtive 1's we can get in arr.

que: 0 1 1 1 0 1 1 0 1 1 0
ans: 0 1 1 1 1 1 1 0 1 1 0, count = 6

TC: Its not O(N^2), instead it is O(N) (refer notes to know why)
SC: O(1)
 */