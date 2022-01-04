package _01_beginner._2021_11_24;

public class _00_AssignmentHalfDiamond {
    public static void main(String[] args) {
        int N = 3;
        int i = 1;

        // half diamond
        while (i <= N ){
            int j = N - i;
            int cnt1 = 0;

            // spaces
            while( cnt1 <= j){
                System.out.print(" ");
                cnt1++;
            }

            // stars
            int x = i;
            int cnt2 = 1;
            while (cnt2 <= (2 * x - 1)){
                System.out.print("*");
                cnt2 += 1;
            }

            i += 1;
            System.out.println("");
        }
    }
}
