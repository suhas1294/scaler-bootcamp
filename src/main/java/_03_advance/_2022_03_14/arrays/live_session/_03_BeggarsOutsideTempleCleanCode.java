package _03_advance._2022_03_14.arrays.live_session;

// refer this file for more details : src/main/java/_01_beginner/_2021_12_12/assignments/BeggarsOutsideTemple.java
public class _03_BeggarsOutsideTempleCleanCode {
    public static int[] solve(int[] arr, int[][] queries) {
        for (int[] query: queries) {
            int startIdx = query[0];
            int endIdx = query[1];
            int value = query[2];
            // let's alter the original array itself
            arr[startIdx] += value;
            if (endIdx + 1 < arr.length){
                arr[endIdx + 1] -= value;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i];
        }
        return arr;
    }
}
