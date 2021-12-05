package beginner._2021_12_03.assignments;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String result = "";
        while(N != 0){
            result += N % 2;
            N = N/2;
        }
        String[] digits = result.split("");
        String reverseDigits = "";
        for (int i = digits.length-1; i >= 0 ; i--) {
            reverseDigits += digits[i];
        }
        System.out.print(reverseDigits);
        //System.out.println(Long.valueOf(reverseDigits));
    }
}
