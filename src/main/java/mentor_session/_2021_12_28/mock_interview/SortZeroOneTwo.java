package mentor_session._2021_12_28.mock_interview;

import utils.Util;

import java.util.Arrays;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] input = {2, 2, 2, 1, 0, 0, 0};
        sortZeroOneTwo(input);
        System.out.println(Arrays.toString(input));
    }
    static void sortZeroOneTwo(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (mid <= end) {
            switch (arr[mid]) {
                case 0: {
                    Util.swapIndicesOfanArray(arr, start, mid);
                    start++; mid++; break;
                }
                case 1:
                    mid++; break;
                case 2: {
                    Util.swapIndicesOfanArray(arr, mid, end);
                    end--; break;
                }
            }
        }
    }
}
