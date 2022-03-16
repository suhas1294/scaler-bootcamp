package _03_advance._2022_03_14.arrays.live_session;

public class _06_RainWaterTrapped {
    public static int getRainWaterTrapped(int[] arr){
        // step-1 : calculate prefix sum Max and suffix sum Max
        int[] pfm = prefixMax(arr);
        int[] sfm = suffixMax(arr);

        int ans = 0;
        for (int i = 1; i < arr.length-1 ; i++) {
            int leftMax = pfm[i-1];
            int rightMax = sfm[i+1];
            int height = Integer.min(leftMax, rightMax);
            int waterLevel = Integer.max(height - arr[i], 0);
            ans += waterLevel;
        }
        return ans;
    }

    public static int[] prefixMax(int[] arr){
        int[] result = new int[arr.length];
        result[0] = arr[0];
        int curMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMax = Integer.max(curMax, arr[i]);
            result[i] = Integer.max(curMax, arr[i]);
        }
        return result;
    }

    public static int[] suffixMax(int[] arr){
        int[] result = new int[arr.length];
        result[arr.length-1] = arr[arr.length-1];
        int curMax = arr[arr.length-1];
        for (int i = arr.length-2 ; i >= 0; i--) {
            curMax = Integer.max(curMax, arr[i]);
            result[i] = Integer.max(arr[i], curMax);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getRainWaterTrapped(new int[]{2,1,3,2,1,2,4,3,2,1,3,1})); // 8
    }
}

/*
given N array elements, where a[i] represents height of a building,
return amount of water trapped on all buildings.
ex: 2 1 3 2 1 2 4 3 2 1 3 1
ans: 8
 */