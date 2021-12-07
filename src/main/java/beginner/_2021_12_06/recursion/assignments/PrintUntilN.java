package beginner._2021_12_06.recursion.assignments;

import java.util.Scanner;

// NOTE: what is limit to recursive memory ? : roughly upto 10^6 recursive calls.

public class PrintUntilN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        dec(N);
        System.out.println();
        inc(N);
    }

    // both inc and dec logic is same, only print statement order matters
    public static void inc(int N){
        if(N == 0) return;
        inc(N-1);
        System.out.print(N + "\t");
    }
    public static void dec(int N){
        if(N == 0) return;
        System.out.print(N + "\t");
        dec(N-1);
    }
}
