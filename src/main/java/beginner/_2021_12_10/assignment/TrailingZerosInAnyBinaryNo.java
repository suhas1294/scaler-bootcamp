package beginner._2021_12_10.assignment;

//import beginner._2021_12_10.live_class.DecToBin;

import java.util.Scanner;

public class TrailingZerosInAnyBinaryNo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        //int N = 79438016; // expected : 6
        System.out.println(solve(N));
    }

    public static int solve(int A){
        int p = 1;
        int ans = 0;
        int counter = 0;
        while (A > 0){
            int rem = A % 2;
            ans = ans + rem * p;
            if (rem == 0){
                counter++;
            }else{
                break;
            }
            p *= 10;
            A = A/2;
        }
        return counter;
    }

    // alternate solution - requires to convert user input to string and then perform computation
    /*public static int solve(int A) {
        String binary = decToBin(A);
        String[] binaryDigits = binary.split("");
        int trailingZerosCounter = 0;
        for (int i = binaryDigits.length-1; i > 0; i--) {
            if (Integer.valueOf(binaryDigits[i]).intValue() == 0){
                trailingZerosCounter++;
            }else {
                break;
            }
        }
        return trailingZerosCounter;
    }

    public static String decToBin(int N){
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
        return reverseDigits;
    }*/
}
