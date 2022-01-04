package _01_beginner._2021_11_25;

import java.util.Scanner;

public class _01SimpleInterest {
    public static void main(String[] args) {
        int p, t ;
        float r;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the principle amount\t");
        p = scanner.nextInt();
        System.out.println("Enter the time in months\t");
        t = scanner.nextInt();
        System.out.println("Enter the rate of interest\t");
        r = scanner.nextFloat();
        System.out.printf("SImple interest is %.2f", ((p*t*r)/100));
    }
}
