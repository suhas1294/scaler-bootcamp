package _01_beginner._2021_12_20.assignment;

import java.util.ArrayList;

public class CountSwapsInBubbleSort {
    public static void main(String[] args) {
        
    }
    public static int solve(ArrayList<Integer> A) {
        int swapCount = 0;
        for (int i = 0; i < A.size()-1; i++) {
            for (int j = 0; j < A.size()-i-1; j++) {
                if (A.get(j) > A.get(j+1)){
                    swapCount++;
                    int temp = A.get(j);
                    A.set(j, A.get(j+1));
                    A.set(j+1, temp);
                }
            }
        }
        return swapCount;
    }
}
