package _01_beginner._2021_12_03.homework;

// Refer Euclidean theorem here for optimized solution explaination : https://www.idomaths.com/hcflcm.php

public class GcdOfTwoNumbersOptimized {
    public static void main(String[] args) {
        System.out.println(solve(24, 60)); // 12
        System.out.println(solve(40, 64)); // 8
        System.out.println(solve(4,6)); // 2
        System.out.println(solve(6,7)); // 1
        System.out.println(solve(2,0)); // 2
        System.out.println(solve(961748927,756065179)); // 1
    }


    public static int solve(int A, int B){
        if (A == 0) return B;
        if (B == 0) return A;

        int divident = Math.max(A, B);
        int divisor = Math.min(A, B);
        int remainder = -1;

        while (remainder != 0){
            remainder = divident % divisor;
            if (remainder ==0) return divisor;
            divident = divisor;
            divisor = remainder;
        }

        return  divisor;
    }
}
