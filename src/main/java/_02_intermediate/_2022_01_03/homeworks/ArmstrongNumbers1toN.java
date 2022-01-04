package _02_intermediate._2022_01_03.homeworks;

import java.util.Scanner;

public class ArmstrongNumbers1toN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 1; i <= N; i++) {
            if (isArmstrongNumber(i)) System.out.println(i);
        }
    }
    static boolean isArmstrongNumber(int n){
        // scaler question: it was always cube, so noOfDigits will always be 3
        int noOfDigits = getNoOfDigits(n);
        int copyOfN = n;
        int sum = 0;
        while(n > 0){
            sum += (int)Math.pow(n%10, 3);
            n = n/10;
        }
        sum += (int)Math.pow(n, noOfDigits);
        return copyOfN == sum;
    }
    static int getNoOfDigits(int n){
        int noOfDigits = 1;
        while(n/10 > 0){
            n = n/10;
            noOfDigits++;
        }
        return noOfDigits;
    }
}
