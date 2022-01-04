package _01_beginner._2021_12_08.homeworks;

import java.util.Scanner;

/*
22
0
433494437
75025
121393
514229
2178309
9227465
267914296
165580141
102334155
63245986
39088169
297121507
183631190
1134903170
832040
514229
317811
196418
46368
1346269
1346270
 */

public class CheckIfNumberExistsInFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            System.out.println(checkIfNoExistsInFibSeries(N) ? "Yes" : "No");
        }
    }
    public static boolean checkIfNoExistsInFibSeries(int n){
        int n1 = 0;
        int n2 = 1;
        int n3 = n1 + n2;
        if (n == n1 || n == n2 || n == n3) return true;
        while (n3 <= n){
            if (n3 == n) return true;
            n1 = n2;
            n2 = n3;
            n3 = n1 + n2;
        }
        return false;
    }
}
