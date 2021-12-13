package beginner._2021_12_10.assignment;

import java.util.Scanner;

public class TrailingZerosInNthFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        // examples
        //int N = 100; // 24
        //int N = 1210; // 300
        System.out.println(getTrailingZeros(N));
    }

    public static int getTrailingZeros(int A){
        int ans = 0;
        int p = 5;
        while (A/p > 0){
            ans += A/p;
            p = p * 5;
        }
        return ans;
    }
}
