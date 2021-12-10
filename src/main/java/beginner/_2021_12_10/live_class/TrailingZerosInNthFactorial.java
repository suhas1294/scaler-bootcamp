package beginner._2021_12_10.live_class;

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

    public static int getTrailingZeros(int n){
        int ans = 0;
        int p = 5;
        while (n/p > 0){
            ans += n/p;
            p = p * 5;
        }
        return ans;
    }
}
