package _01_beginner._2021_12_10.live_class;

import java.util.Scanner;

public class BinToDec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int n = 1100;
        System.out.println(binToDec(n));
    }

    public static int binToDec(int n){
        int ans = 0;
        int p = 1;
        while (n > 0){
            int lastDigit = n % 10;
            ans += lastDigit * p;
            p *= 2;
            n = n/10;
        }
        return ans;
    }
}
