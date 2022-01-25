package _01_beginner._2021_11_24;

import java.util.Scanner;

public class _05_PrimeInRange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter starting number");
        int start = scanner.nextInt();
        System.out.println("Enter ending number");
        int end = scanner.nextInt();

        System.out.println("Prime numbers in the range are:");

        while (start < end){

            int init = 2;
            int primeCounter = 0;

            while(init <= Math.sqrt(start)){
                if (start % init == 0){
                    primeCounter++;
                }
                init++;
            }

            if(primeCounter == 0){
                System.out.printf("%d\t", start);
            }
            start++;
        }

    }
}
