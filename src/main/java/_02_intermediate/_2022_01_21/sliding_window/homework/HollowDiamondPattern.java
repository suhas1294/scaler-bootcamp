package _02_intermediate._2022_01_21.sliding_window.homework;

import java.util.Scanner;

public class HollowDiamondPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // first half diamond (see obs in below comments)
        int gap = 0;
        for (int i = 2*n; i >= 2 ; i-=2, gap+=2) {
            for (int j = 0; j < i/2; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < gap; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i/2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        gap -= 2;
        // second half diamond (see obs in below comments)
        for (int i = 2 ; i <= 2*n ; i+=2, gap-=2) {
            for (int j = 0; j < i/2; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < gap; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i/2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/*
Write a program to input an integer N from user and print hollow diamond star pattern series of N lines.
See example for clarifications over the pattern.

constraints: 1 <= N <= 1000
input format: First line is an integer N
output format: N lines conatining only char '*' as per the question.

input 1 : N = 4, output :
********
***  ***
**    **
*      *
*      *
**    **
***  ***
********

input 2 : 6
output :
************
*****  *****
****    ****
***      ***
**        **
*          *
*          *
**        **
***      ***
****    ****
*****  *****
************
 */