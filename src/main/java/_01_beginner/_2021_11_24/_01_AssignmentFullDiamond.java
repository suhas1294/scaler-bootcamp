package _01_beginner._2021_11_24;

import java.util.Scanner;
public class _01_AssignmentFullDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        if(N % 2 == 0) N+=1;
        //int N = 21;
        int i = 1;
        int lowerDiamondStartInitCount = 1;

        // outermost loop to ensure we print N number of lines which forms a diamond
        while(i <= N){

            int diamondHeight = N/2;
            if(i <= (N/2 + 1)){
                // upper half diamond (including line with max stars)
                int cnt = 0;
                // spaces
                int spaces_count = diamondHeight-i;
                while(cnt <= spaces_count){
                    System.out.print(" ");
                    cnt++;
                }
                // stars
                int cnt1 = 0;
                int star_count = ((2 * i) - 1);
                while(cnt1 < star_count){
                    System.out.print("*");
                    cnt1++;
                }

            }else{
                // lower half diamond
                int lowerDiamondHeight = N/2;
                int cnt = 0;

                // spaces
                int space_count = i - lowerDiamondHeight - 1;
                while (cnt < space_count){
                    System.out.print(" ");
                    cnt++;
                }

                // stars
                int star_count = N -(2 * lowerDiamondStartInitCount);
                int cnt1 = 1;
                while (cnt1 <= star_count){
                    System.out.print("*");
                    cnt1++;
                }
                lowerDiamondStartInitCount++;

            }
            System.out.println("");
            i++;
        }
    }
}
