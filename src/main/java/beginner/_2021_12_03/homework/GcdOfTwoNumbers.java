package beginner._2021_12_03.homework;

//  THIS FAILS IN TIME COMPLEXITY FOR LARGER NUMBERS !!

public class GcdOfTwoNumbers {
    public static void main(String[] args) {
        System.out.println(solve(4,6)); // 2
        System.out.println(solve(6,7)); // 1
        System.out.println(solve(2,0)); // 2
    }
    public static int solve(int A, int B){
        if (A == 0) return B;
        if (B == 0) return A;
        int minNum = Integer.min(A, B);
        int gcd = 1;
        int cnt = 2;
        while (cnt <= minNum){
            if((A % cnt == 0) && (B % cnt == 0)){
                gcd = cnt;
            }
            cnt++;
        }
        return gcd;
    }
}
