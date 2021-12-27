package beginner._2021_12_20.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 2};
        List<Integer> input = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            input.add(arr[i]);
        }
        System.out.println(kthsmallest(input, 3));
    }
    public static int kthsmallest(final List<Integer> A, int B) {
        int[] arr = new int[A.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = A.get(i);
        }
        Arrays.sort(arr);
        return arr[B-1];
    }
}
