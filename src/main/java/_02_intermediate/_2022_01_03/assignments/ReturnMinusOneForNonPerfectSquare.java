package _02_intermediate._2022_01_03.assignments;

public class ReturnMinusOneForNonPerfectSquare {
    public static void main(String[] args) {
        //System.out.println(solve(132));
        System.out.println(solve(1065024)); // 1032
        //System.out.println(532512 * 532512); // expected : 283569030144
        //System.out.println(Math.pow(532512, 2) > Integer.MAX_VALUE);
        //System.out.println(Integer.MAX_VALUE);
    }
    public static int solve(int A) {
        if (A == 0 || A == 1) return A;
        long start = 1, end = A, ans=-1;
        while (start <= end){
            long mid = (start + end) / 2;
            if (mid*mid == A) return (int)mid;
            if (mid*mid < A) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans * ans == A ? (int)ans : -1;
    }
}
