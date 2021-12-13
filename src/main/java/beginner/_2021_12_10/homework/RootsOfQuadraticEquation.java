package beginner._2021_12_10.homework;

import java.util.Scanner;

/**
 * You are given values of coefficients A, B and C of a quadratic equation : A * X2 + B * X + C = 0.
 * You have to tell whether the roots of equation are:
 * Real and distinct
 * Real and equal
 * Imaginary / Complex
 *
 * -1000 <= A, B, C <= 1000
 *
 * Input format:
 * First line of the input contains a single integer A.
 * Second line of the input contains a single integer B.
 * Third line of the input contains a single integer C.
 *
 * output format:
 * If the roots are real and distinct, print 1.
 * If the root are real and equal, print 0.
 * If the roots are complex or imaginary, print -1.
 *
 * ex: input 1 : 8, -4, -2, output : 1
 * explanation: Discriminant (D) = B * B - 4 * A * C = (-4) * (-4) - 4 * 8 * (-2) = 80 As D > 0, the roots are real and distinct.
 * ex: input 1 : 3, 1, 2 output : -1
 * explanation: Discriminant (D) = B * B - 4 * A * C = 1 * 1 - 4 * 3 * 2
 *                   = 1 - 24
 *                   = -23
 *  As D < 0, the roots are complex.
 */
public class RootsOfQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int intermediateResult = ((int)Math.pow(b, 2) - 4*a*c);
        if (intermediateResult < 0){
            System.out.println(-1);
            return;
        }else {
            int root1 = (-(b)+intermediateResult)/(2*a);
            int root2 = (-(b)-intermediateResult)/(2*a);
            if (root1 == root2){
                System.out.println(0);
            }else {
                System.out.println(1);
            }
        }
    }
}
