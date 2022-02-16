package _02_intermediate._2022_01_28.bit_manipulation.live_session;

public class _05_MaxConsequtiveOnes_Swap {
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
                // small change from prev example
                if(totalOnes > (left + right)){
                    ans = Math.max(ans, (left + right + 1) );
                }else{
                    ans = Math.max(ans, (left + right) );
                }
            }
        }
        return ans;
    }
}
