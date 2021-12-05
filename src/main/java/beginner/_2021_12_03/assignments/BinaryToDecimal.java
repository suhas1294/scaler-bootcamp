package beginner._2021_12_03.assignments;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.next();
        int sum = 0 ;
        String[] digits = N.split("");
        int pow = 0;
        for (int i = digits.length-1; i >= 0 ; i--, pow++) {
            int intDigit = Integer.valueOf(digits[i]);
            sum += (intDigit * (int)Math.pow(2, pow));
        }
        System.out.println(sum);
    }
}
