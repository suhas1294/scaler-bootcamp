package beginner._2021_11_24;

import java.util.Scanner;

public class _04_AssignmentGcdArray {

    static int gcdOfTwoNumbers(int num1, int num2){
        int gcd = 1;
        int cnt = 2;
        int minNum = Integer.min(num1, num2);
        while (cnt <= minNum){
            if((num1 % cnt == 0) && (num2 % cnt == 0)){
                gcd = cnt;
            }
            cnt++;
        }
        return gcd;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HOw many numbers u want to get gcd for ?");
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.printf("Enter %dth number :\n", i+1);
            numbers[i] = scanner.nextInt();
        }
        System.out.println("Input array :");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%d\t", numbers[i]);
        }

        int cnt = 1;
        int gcd = gcdOfTwoNumbers(numbers[0], numbers[cnt]);
        while (cnt < numbers.length-1){
            gcd = gcdOfTwoNumbers(gcd, numbers[cnt+1]);
            cnt++;
        }

        System.out.printf("\nGcd of array is %d", gcd);
    }
}
