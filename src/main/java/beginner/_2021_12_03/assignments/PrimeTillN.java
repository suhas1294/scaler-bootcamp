package beginner._2021_12_03.assignments;

import java.util.Scanner;

public class PrimeTillN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N <= 1){
            System.out.printf("There are no prime numbers less than or equal to %d", N);
        }else{
            for(int i = 2; i <= N; i++) {
                int primeCounter = 0;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if(i % j == 0){
                        primeCounter++;
                        break;
                    }
                }
                if (primeCounter == 0) System.out.print(i + " ");
            }
        }
    }
}
